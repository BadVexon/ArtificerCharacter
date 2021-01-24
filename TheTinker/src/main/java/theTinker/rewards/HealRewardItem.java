package theTinker.rewards;

import basemod.abstracts.CustomReward;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.MedicalKit;
import theTinker.patches.RewardItemTypeEnumPatch;
import theTinker.util.TextureLoader;

public class HealRewardItem extends CustomReward {

    public HealRewardItem() {
        super(ImageMaster.ENDLESS_ICON, "Heal 10 HP.", RewardItemTypeEnumPatch.BONUS_HEAL);
    }

    @Override
    public boolean claimReward() {
        if (AbstractDungeon.screen == AbstractDungeon.CurrentScreen.COMBAT_REWARD) {
            AbstractDungeon.player.heal(10);
        }
        return true;
    }
}