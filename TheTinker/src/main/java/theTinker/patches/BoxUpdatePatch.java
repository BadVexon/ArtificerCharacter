package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import theTinker.characters.TheTinker;

import static theTinker.TinkerMod.newHitbox;

@SpirePatch(
        clz = EnergyPanel.class,
        method = "update"
)
public class BoxUpdatePatch {
    public static void Prefix(EnergyPanel __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            newHitbox.dragUpdate();
            newHitbox.update();
        }
    }
}
