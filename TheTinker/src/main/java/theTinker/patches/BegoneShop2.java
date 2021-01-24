package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.ShopScreen;
import theTinker.characters.TheTinker;

@SpirePatch(
        clz = ShopScreen.class,
        method = "renderPurge"
)
public class BegoneShop2 {
    public static SpireReturn Prefix(ShopScreen __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }
}