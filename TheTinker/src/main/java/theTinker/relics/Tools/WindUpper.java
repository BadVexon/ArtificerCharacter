package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class WindUpper extends AbstractTool {
    public static String ID = TinkerMod.makeID(WindUpper.class.getSimpleName());

    public WindUpper() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 2);
    }

    public void activate(AbstractPlayer p) {
        getCoolestTool().flash();
        getCoolestTool().counter -= 1;
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
baseCooldown -= 1;
    }
}
