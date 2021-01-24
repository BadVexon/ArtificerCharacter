package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.NeowsLament;
import theTinker.characters.TheTinker;

@SpirePatch(
        clz = AbstractRelic.class,
        method = "update"
)

public class NeowsLamentPatch {
    private static final float PAD_X = 72.0F * Settings.scale;
    public static SpireReturn Prefix(AbstractRelic __instance) {
        if (AbstractDungeon.player instanceof TheTinker && __instance instanceof NeowsLament) {
            __instance.currentX = (float) (-AbstractRelic.relicPage * Settings.WIDTH) +  (PAD_X + 36.0F * Settings.scale);
            __instance.targetX = __instance.currentX;
        }
        return SpireReturn.Continue();
    }
}