package theTinker.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import com.megacrit.cardcrawl.ui.campfire.SmithOption;
import theTinker.TinkerMod;
import theTinker.campfire.RechargeRelicOption;
import theTinker.campfire.ScrapRelicOption;
import theTinker.campfire.UpgradeRelicOption;
import theTinker.characters.TheTinker;

import java.util.ArrayList;

@SpirePatch(
        cls = "com.megacrit.cardcrawl.rooms.CampfireUI",
        method = "initializeButtons"
)
public class InitializeButtonsPatches {
    public static void Postfix(Object __instance) { // "This is not mine and I think this patch sucks too." - BD
        CampfireUI campfire = (CampfireUI) __instance;
        try {
            @SuppressWarnings("unchecked")
            ArrayList<AbstractCampfireOption> campfireButtons = (ArrayList<AbstractCampfireOption>) ReflectionHacks.getPrivate(campfire, CampfireUI.class, "buttons");
            if (AbstractDungeon.player instanceof TheTinker) {
                campfireButtons.removeIf(q -> q instanceof SmithOption);
                if (TinkerMod.hasUpgradableRelics()) {
                    campfireButtons.add(new UpgradeRelicOption());
                }
                if (TinkerMod.hasUnchargedMachines()) {
                    campfireButtons.add(new RechargeRelicOption());
                }
                if (!AbstractDungeon.player.relics.isEmpty()) {
                    campfireButtons.add(new ScrapRelicOption());
                }
            }
        } catch (SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}