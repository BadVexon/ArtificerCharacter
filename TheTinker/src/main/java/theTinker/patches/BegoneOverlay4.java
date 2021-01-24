package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.ui.panels.DrawPilePanel;
import com.megacrit.cardcrawl.ui.panels.ExhaustPanel;
import theTinker.characters.TheTinker;

@SpirePatch(
        clz = ExhaustPanel.class,
        method = "updatePositions"
)
public class BegoneOverlay4 {
    public static SpireReturn Prefix(ExhaustPanel __instance) {
        if (AbstractDungeon.player instanceof TheTinker && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }
}