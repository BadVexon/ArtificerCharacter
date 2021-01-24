package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class DualCardinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(DualCardinator.class.getSimpleName());

    public DualCardinator() {
        super(ID, "DualCardinator.png", "DualCardinator.png", RelicTier.RARE, LandingSound.FLAT, 4);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new AddStolenCardAction(false));
        atb(new AddStolenCardAction(false));
    }
}
