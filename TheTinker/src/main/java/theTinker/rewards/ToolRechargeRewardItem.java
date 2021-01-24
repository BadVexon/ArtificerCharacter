package theTinker.rewards;

import basemod.abstracts.CustomReward;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.patches.RewardItemTypeEnumPatch;
import theTinker.relics.Machines.AbstractMachine;
import theTinker.relics.Tools.AbstractTool;
import theTinker.util.TextureLoader;

public class ToolRechargeRewardItem extends CustomReward {

    public ToolRechargeRewardItem() {
        super(ImageMaster.SETTINGS_ICON, "Reset your Tools.", RewardItemTypeEnumPatch.TOOL_RECHRAGE);
    }

    @Override
    public boolean claimReward() {
        if (AbstractDungeon.screen == AbstractDungeon.CurrentScreen.COMBAT_REWARD) {
            for (AbstractRelic r : AbstractDungeon.player.relics) {
                if (r instanceof AbstractTool) {
                    r.flash();
                    r.counter = 0;
                }
            }
        }
        return true;
    }
}