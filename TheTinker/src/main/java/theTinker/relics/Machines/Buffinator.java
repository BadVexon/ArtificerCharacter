package theTinker.relics.Machines;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class Buffinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Buffinator.class.getSimpleName());

    public Buffinator() {
        super(ID, "Buffinator.png", "Buffinator.png", RelicTier.UNCOMMON, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new AddTemporaryHPAction(p, p, 8));
    }
}
