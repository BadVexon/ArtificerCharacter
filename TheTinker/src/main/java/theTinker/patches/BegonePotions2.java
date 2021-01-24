package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import theTinker.characters.TheTinker;

@SpirePatch(
        clz = AbstractRoom.class,
        method = "addPotionToRewards",
        paramtypez = {
                AbstractPotion.class
        }
)

public class BegonePotions2 {
    public static SpireReturn Prefix(AbstractRoom __instance, AbstractPotion potion) {
        if (AbstractDungeon.player instanceof TheTinker) {
            return SpireReturn.Return(null);
        }
        return SpireReturn.Continue();
    }
}