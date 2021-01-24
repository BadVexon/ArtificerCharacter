package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import theTinker.characters.TheTinker;

import static theTinker.TinkerMod.newHitbox;
import static theTinker.TinkerMod.newHitbox2;

@SpirePatch(
        clz = EnergyPanel.class,
        method = "update"
)
public class BoxUpdatePatch2 {
    public static void Prefix(EnergyPanel __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            newHitbox2.dragUpdate();
            newHitbox2.update();
        }
    }
}
