package theTinker.campfire;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import theTinker.TinkerMod;

public class RechargeRelicOption extends AbstractCampfireOption {

    public RechargeRelicOption() {
        this.label = "Recharge";
        this.description = "Recharge one of your Machines.";
        this.img = ImageMaster.loadImage(TinkerMod.makeRelicPath("Upgrade.png"));
    }

    @Override
    public void useOption() {
        AbstractDungeon.effectList.add(new CampfireRechargeEffect());
    }
}