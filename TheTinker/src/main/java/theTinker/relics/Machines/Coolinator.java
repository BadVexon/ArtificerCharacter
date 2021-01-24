package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Tools.AbstractTool;

public class Coolinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Coolinator.class.getSimpleName());

    public Coolinator() {
        super(ID, "Coolinator.png", "Coolinator.png", RelicTier.RARE, LandingSound.FLAT, 2);
    }

    @Override
    public void activate(AbstractPlayer p) {
        for (AbstractRelic r : adp().relics) {
            if (r instanceof AbstractTool) {
                if (((AbstractTool) r).cooldown > 1) {
                    r.flash();
                    ((AbstractTool) r).cooldown -= 1;
                }
            }
        }
    }
}
