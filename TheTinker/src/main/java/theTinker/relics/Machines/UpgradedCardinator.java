package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class UpgradedCardinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(UpgradedCardinator.class.getSimpleName());

    public UpgradedCardinator() {
        super(ID, "UpgradedCardinator.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 5);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new AddStolenCardAction(true));
    }
}
