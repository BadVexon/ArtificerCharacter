package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.EventHelper;
import com.megacrit.cardcrawl.helpers.ModHelper;
import com.megacrit.cardcrawl.random.Random;
import com.megacrit.cardcrawl.rooms.RestRoom;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import theTinker.characters.TheTinker;

import java.util.Collections;

public class BegoneEvents {
    @SpireEnum
    public static EventHelper.RoomResult VEX_REST;

    @SpirePatch(clz = EventHelper.class, method = "roll", paramtypez = {Random.class})
    public static class AddRestToEvent {
        public static EventHelper.RoomResult Postfix(EventHelper.RoomResult __result, Random eventRng) {
            if (AbstractDungeon.player instanceof TheTinker) {
                if (__result == EventHelper.RoomResult.EVENT) {
                    return VEX_REST;
                }
            }

            return __result;
        }
    }

    private static class Locator extends SpireInsertLocator {
        public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(ModHelper.class, "isModEnabled");
            return LineFinder.findInOrder(ctMethodToPatch, Collections.singletonList(finalMatcher), finalMatcher);
        }
    }

    @SpirePatch(clz = AbstractDungeon.class, method = "generateRoom")
    public static class RoomGenerationPatch
    {
        public static SpireReturn Prefix(AbstractDungeon __instance, EventHelper.RoomResult roomType)
        {
            if (roomType == VEX_REST)
            {
                return SpireReturn.Return(new RestRoom());
            }
            return SpireReturn.Continue();
        }
    }
}