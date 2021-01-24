package theTinker.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.TopPanel;
import theTinker.TinkerMod;
import theTinker.characters.TheTinker;
import theTinker.util.BoxHelper3;

@SpirePatch(
        clz = TopPanel.class,
        method = "render",
        paramtypes = {"com.badlogic.gdx.graphics.g2d.SpriteBatch"}
)
public class BoxRenderPatch3 {
    public static void Prefix(TopPanel __instance, SpriteBatch sb) {
        if (AbstractDungeon.player instanceof TheTinker) {
            BoxHelper3.renderGenericTip(TinkerMod.newHitbox3.hb.x, TinkerMod.newHitbox3.hb.y + (TinkerMod.newHitbox3.hb.height / 1.33F), "Machines", " NL ");
            BoxHelper3.render(sb);
        }
    }
}
