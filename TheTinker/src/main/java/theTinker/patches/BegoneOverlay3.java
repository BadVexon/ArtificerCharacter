package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.ui.panels.DiscardPilePanel;
import theTinker.characters.TheTinker;

@SpirePatch(
        clz = DiscardPilePanel.class,
        method = "updatePositions"
)
public class BegoneOverlay3 {
    public static SpireReturn Prefix(DiscardPilePanel __instance) {
        if (AbstractDungeon.player instanceof TheTinker && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }
}