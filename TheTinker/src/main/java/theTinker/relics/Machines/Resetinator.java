package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class Resetinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Resetinator.class.getSimpleName());

    public Resetinator() {
        super(ID, "Resetinator.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 4);
    }

    @Override
    public void activate(AbstractPlayer p) {
        AbstractRelic r = getRandomHotTool();
        if (r != null) {
            r.flash();
            r.counter = 0;
        }
    }
}
