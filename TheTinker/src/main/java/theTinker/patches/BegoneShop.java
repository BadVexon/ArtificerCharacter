package theTinker.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.ShopScreen;
import theTinker.characters.TheTinker;

import java.util.ArrayList;

@SpirePatch(
        clz = ShopScreen.class,
        method = "initCards"
)
public class BegoneShop {
    public static void Postfix(ShopScreen __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            ArrayList<AbstractCard> blah = (ArrayList<AbstractCard>) ReflectionHacks.getPrivate(__instance, ShopScreen.class, "coloredCards");
            blah.clear();
            ArrayList<AbstractCard> bleh = (ArrayList<AbstractCard>) ReflectionHacks.getPrivate(__instance, ShopScreen.class, "colorlessCards");
            bleh.clear();
        }
    }
}