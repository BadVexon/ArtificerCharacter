package theTinker.patches;

import basemod.ReflectionHacks;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.TipHelper;
import com.megacrit.cardcrawl.helpers.input.InputActionSet;
import com.megacrit.cardcrawl.ui.panels.TopPanel;
import javassist.CtBehavior;
import theTinker.characters.TheTinker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.megacrit.cardcrawl.ui.panels.TopPanel.MSG;

@SpirePatch(
        clz = TopPanel.class,
        method = "renderTopRightIcons"
)
public class BegoneDeck {
    @SpireInsertPatch(
            locator = Locator.class
    )
    public static SpireReturn Insert(TopPanel __instance, SpriteBatch sb) {
        if (AbstractDungeon.player instanceof TheTinker) {
            if ((Boolean) ReflectionHacks.getPrivate(__instance, TopPanel.class, "mapButtonDisabled")) {// 1825
                sb.setColor((Color) ReflectionHacks.getPrivate(__instance, TopPanel.class, "DISABLED_BTN_COLOR"));// 1826
            } else if (__instance.mapHb.hovered) {// 1828
                sb.setColor(Color.CYAN);// 1829
                if (AbstractDungeon.screen != AbstractDungeon.CurrentScreen.MASTER_DECK_VIEW) {// 1830
                    TipHelper.renderGenericTip((float) ReflectionHacks.getPrivateStatic(TopPanel.class, "TOP_RIGHT_TIP_X"), (float) ReflectionHacks.getPrivateStatic(TopPanel.class, "TIP_Y"), TopPanel.LABEL[2] + " (" + InputActionSet.map.getKeyString() + ")", MSG[2]);// 1831 1834
                }
            } else {
                sb.setColor(Color.WHITE);// 1838
            }
            try {
                Method MapIconRender = null;
                MapIconRender = TopPanel.class.getDeclaredMethod("renderMapIcon", SpriteBatch.class);
                MapIconRender.setAccessible(true);
                MapIconRender.invoke(__instance, sb);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }

    private static class Locator extends SpireInsertLocator {
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(TopPanel.class, "renderDeckIcon");
            return LineFinder.findInOrder(ctMethodToPatch, finalMatcher);
        }
    }
}
