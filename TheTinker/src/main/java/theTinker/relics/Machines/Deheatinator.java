package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class Deheatinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Deheatinator.class.getSimpleName());

    public Deheatinator() {
        super(ID, "Deheatinator.png", "Deheatinator.png", RelicTier.BOSS, LandingSound.FLAT, 15);
    }

    @Override
    public void activate(AbstractPlayer p) {
        AbstractRelic r = getRandomHotTool();
        if (r != null) {
            r.flash();
            r.counter -= 1;
        }
    }
}
