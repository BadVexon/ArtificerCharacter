package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import theTinker.characters.TheTinker;

import static theTinker.TinkerMod.newHitbox2;
import static theTinker.TinkerMod.newHitbox3;

@SpirePatch(
        clz = EnergyPanel.class,
        method = "update"
)
public class BoxUpdatePatch3 {
    public static void Prefix(EnergyPanel __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            newHitbox3.dragUpdate();
            newHitbox3.update();
        }
    }
}
