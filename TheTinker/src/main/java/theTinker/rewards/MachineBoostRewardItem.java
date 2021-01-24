package theTinker.rewards;

import basemod.abstracts.CustomReward;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.patches.RewardItemTypeEnumPatch;
import theTinker.relics.Machines.AbstractMachine;
import theTinker.util.TextureLoader;

public class MachineBoostRewardItem extends CustomReward {

    public MachineBoostRewardItem() {
        super(ImageMaster.SETTINGS_ICON, "Give all Machines +1 Charge.", RewardItemTypeEnumPatch.MACHINE_BOOST);
    }

    @Override
    public boolean claimReward() {
        if (AbstractDungeon.screen == AbstractDungeon.CurrentScreen.COMBAT_REWARD) {
            for (AbstractRelic r : AbstractDungeon.player.relics) {
                if (r instanceof AbstractMachine) {
                    r.flash();
                    r.counter++;
                }
            }
        }
        return true;
    }
}