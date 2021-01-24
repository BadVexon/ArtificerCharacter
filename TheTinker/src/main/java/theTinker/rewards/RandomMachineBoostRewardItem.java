package theTinker.rewards;

import basemod.abstracts.CustomReward;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.characters.TheTinker;
import theTinker.patches.RewardItemTypeEnumPatch;
import theTinker.relics.AbstractTinkerRelic;
import theTinker.util.TextureLoader;

public class RandomMachineBoostRewardItem extends CustomReward {

    public RandomMachineBoostRewardItem() {
        super(ImageMaster.SETTINGS_ICON, "Give a random Machine +2 Charges.", RewardItemTypeEnumPatch.RANDOM_MACHINE_BOOST);
    }

    @Override
    public boolean claimReward() {
        if (AbstractDungeon.screen == AbstractDungeon.CurrentScreen.COMBAT_REWARD) {
            if (AbstractDungeon.player instanceof TheTinker) {
                AbstractRelic r = AbstractTinkerRelic.getRandomMachine();
                if (r != null) {
                    r.flash();
                    r.counter += 2;
                }
            }
        }
        return true;
    }
}