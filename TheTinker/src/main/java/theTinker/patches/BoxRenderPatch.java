package theTinker.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.ui.panels.TopPanel;
import theTinker.TinkerMod;
import theTinker.characters.TheTinker;
import theTinker.util.BoxHelper;

@SpirePatch(
        clz = TopPanel.class,
        method = "render",
        paramtypes = {"com.badlogic.gdx.graphics.g2d.SpriteBatch"}
)
public class BoxRenderPatch {
    public static void Prefix(TopPanel __instance, SpriteBatch sb) {
        if (AbstractDungeon.player instanceof TheTinker) {
            BoxHelper.renderGenericTip(TinkerMod.newHitbox.hb.x, TinkerMod.newHitbox.hb.y + (TinkerMod.newHitbox.hb.height / 1.33F), "Drones", " NL ");
            BoxHelper.render(sb);
        }
    }
}
