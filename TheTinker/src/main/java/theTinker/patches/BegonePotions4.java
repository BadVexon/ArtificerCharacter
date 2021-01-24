package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.TopPanel;
import theTinker.characters.TheTinker;

@SpirePatch(
        clz = TopPanel.class,
        method = "updatePotions"
)
public class BegonePotions4 {
    public static SpireReturn Prefix(TopPanel __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }
}
