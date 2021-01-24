package theTinker.campfire;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import theTinker.TinkerMod;

public class UpgradeRelicOption extends AbstractCampfireOption {

    public UpgradeRelicOption() {
        this.label = "Tinker";
        this.description = "Upgrade one of your Tools.";
        this.img = ImageMaster.loadImage(TinkerMod.makeRelicPath("Upgrade.png"));
    }

    @Override
    public void useOption() {
        AbstractDungeon.effectList.add(new CampfireUpgradeEffect());
    }
}