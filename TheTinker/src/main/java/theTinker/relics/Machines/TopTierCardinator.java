package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class TopTierCardinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(TopTierCardinator.class.getSimpleName());

    public TopTierCardinator() {
        super(ID, "TopTierCardinator.png", "Placeholder.png", RelicTier.BOSS, LandingSound.FLAT, 5);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new AddStolenCardAction(true));
        atb(new AddStolenCardAction(true));
    }
}
