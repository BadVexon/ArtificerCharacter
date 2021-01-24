package theTinker.rewards;

import basemod.abstracts.CustomReward;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import theTinker.patches.RewardItemTypeEnumPatch;
import theTinker.util.TextureLoader;

public class BonusGoldRewardItem extends CustomReward {

    public BonusGoldRewardItem() {
        super(ImageMaster.UI_GOLD, "Gain 25 Gold.", RewardItemTypeEnumPatch.BONUS_HEAL);
    }

    @Override
    public boolean claimReward() {
        if (AbstractDungeon.screen == AbstractDungeon.CurrentScreen.COMBAT_REWARD) {
            AbstractDungeon.player.gainGold(25);
        }
        return true;
    }
}