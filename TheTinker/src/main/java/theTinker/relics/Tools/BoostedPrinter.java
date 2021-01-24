package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class BoostedPrinter extends AbstractTool {
    public static String ID = TinkerMod.makeID(BoostedPrinter.class.getSimpleName());

    public BoostedPrinter() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 4);
    }

    public void activate(AbstractPlayer p) {
        atb(new AddStolenCardAction(true));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        this.baseCooldown -= 1;
    }
}
