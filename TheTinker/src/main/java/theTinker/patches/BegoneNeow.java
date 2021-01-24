package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.neow.NeowEvent;
import com.megacrit.cardcrawl.screens.select.GridCardSelectScreen;
import theTinker.characters.TheTinker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpirePatch(
        clz = NeowEvent.class,
        method = "blessing"
)
public class BegoneNeow {
    public static SpireReturn Prefix(NeowEvent __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            try {
                Method m = NeowEvent.class.getDeclaredMethod("miniBlessing");
                m.setAccessible(true);
                m.invoke(__instance);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignore) {
            }
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }
}
