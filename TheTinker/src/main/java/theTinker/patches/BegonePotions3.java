package theTinker.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.TopPanel;
import theTinker.characters.TheTinker;

@SpirePatch(
        clz = TopPanel.class,
        method = "renderPotions"
)
public class BegonePotions3 {
    public static SpireReturn Prefix(TopPanel __instance, SpriteBatch sb) {
        if (AbstractDungeon.player instanceof TheTinker) {
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }
}
