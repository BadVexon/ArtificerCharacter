package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Tools.AbstractTool;

public class Optimizinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Optimizinator.class.getSimpleName());

    public Optimizinator() {
        super(ID, "Optimizinator.png", "Optimizinator.png", RelicTier.UNCOMMON, LandingSound.FLAT, 4);
    }

    @Override
    public void activate(AbstractPlayer p) {
        AbstractRelic r = getRandomTool();
        if (r != null) {
            r.flash();
            ((AbstractTool) r).cooldown -= 1;
        }
    }
}
