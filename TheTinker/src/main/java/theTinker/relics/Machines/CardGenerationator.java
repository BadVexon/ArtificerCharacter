package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class CardGenerationator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(CardGenerationator.class.getSimpleName());

    public CardGenerationator() {
        super(ID, "CardGenerationator.png", "CardGenerationator.png", RelicTier.UNCOMMON, LandingSound.FLAT, 4);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new AddStolenCardAction(false));
    }
}
