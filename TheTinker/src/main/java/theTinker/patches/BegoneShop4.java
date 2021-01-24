package theTinker.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.ShopScreen;
import com.megacrit.cardcrawl.shop.StorePotion;
import theTinker.characters.TheTinker;

import java.util.ArrayList;

@SpirePatch(
        clz = ShopScreen.class,
        method = "initPotions"
)
public class BegoneShop4 {
    public static void Postfix(ShopScreen __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            ArrayList<StorePotion> blah = (ArrayList<StorePotion>) ReflectionHacks.getPrivate(__instance, ShopScreen.class, "potions");
            blah.clear();
        }
    }
}