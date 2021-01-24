package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.characters.TheTinker;

import java.util.ArrayList;

@SpirePatch(
        clz = AbstractDungeon.class,
        method = "getRewardCards"
)
public class BegoneCards {
    public static SpireReturn Prefix() {
        if (AbstractDungeon.player instanceof TheTinker) {
            ArrayList<AbstractCard> blah = new ArrayList<>();
            return SpireReturn.Return(blah);
        }
        return SpireReturn.Continue();
    }
}
