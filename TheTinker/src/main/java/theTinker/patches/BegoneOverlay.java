package theTinker.patches;

import basemod.ReflectionHacks;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.OverlayMenu;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import theTinker.characters.TheTinker;

@SpirePatch(
        clz = OverlayMenu.class,
        method = "render"
)
public class BegoneOverlay {
    @SpireInsertPatch(
            rloc = 0
    )
    public static SpireReturn noRenderOverlay(OverlayMenu __instance, SpriteBatch sb) {
        __instance.endTurnButton.render(sb);
        AbstractPlayer p = (AbstractPlayer) ReflectionHacks.getPrivate(__instance, OverlayMenu.class, "player");
        p.renderHand(sb);
        p.hand.renderTip(sb);
        if (AbstractDungeon.player instanceof TheTinker && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }
}