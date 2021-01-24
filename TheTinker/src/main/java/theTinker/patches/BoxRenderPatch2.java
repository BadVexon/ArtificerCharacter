package theTinker.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.ui.panels.TopPanel;
import theTinker.TinkerMod;
import theTinker.characters.TheTinker;
import theTinker.util.BoxHelper2;

@SpirePatch(
        clz = TopPanel.class,
        method = "render",
        paramtypes = {"com.badlogic.gdx.graphics.g2d.SpriteBatch"}
)
public class BoxRenderPatch2 {
    public static void Prefix(TopPanel __instance, SpriteBatch sb) {
        if (AbstractDungeon.player instanceof TheTinker) {
            BoxHelper2.renderGenericTip(TinkerMod.newHitbox2.hb.x, TinkerMod.newHitbox2.hb.y + (TinkerMod.newHitbox2.hb.height / 1.33F), "Tools", " NL ");
            BoxHelper2.render(sb);
        }
    }
}
