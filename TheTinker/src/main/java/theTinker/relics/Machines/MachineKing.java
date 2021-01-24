package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class MachineKing extends AbstractMachine {
    public static String ID = TinkerMod.makeID(MachineKing.class.getSimpleName());

    public MachineKing() {
        super(ID, "MachineKing.png", "MachineKing.png", RelicTier.BOSS, LandingSound.FLAT, 2);
    }

    @Override
    public void activate(AbstractPlayer p) {
        for (AbstractRelic r : adp().relics) {
            if (r instanceof AbstractMachine && !(r instanceof MachineKing)) {
                r.flash();
                r.counter++;
            }
        }
    }
}
