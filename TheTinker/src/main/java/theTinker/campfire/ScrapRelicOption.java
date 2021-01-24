package theTinker.campfire;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import theTinker.TinkerMod;

public class ScrapRelicOption extends AbstractCampfireOption {

    public ScrapRelicOption() {
        this.label = "Scrap";
        this.description = "Destroy one of your Relics and gain 100 Gold.";
        this.img = ImageMaster.loadImage(TinkerMod.makeRelicPath("Upgrade.png"));
    }

    @Override
    public void useOption() {
        AbstractDungeon.effectList.add(new CampfireScrapEffect());
    }
}