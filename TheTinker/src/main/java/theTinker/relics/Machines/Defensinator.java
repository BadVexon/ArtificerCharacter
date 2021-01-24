package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class Defensinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Defensinator.class.getSimpleName());

    public Defensinator() {
        super(ID, "Defensinator.png", "Defensinator.png", RelicTier.COMMON, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, 8));
    }
}
