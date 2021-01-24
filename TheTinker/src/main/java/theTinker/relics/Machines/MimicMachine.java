package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.MachineActivateAction;

public class MimicMachine extends AbstractMachine {
    public static String ID = TinkerMod.makeID(MimicMachine.class.getSimpleName());

    public MimicMachine() {
        super(ID, "MimicMachine.png", "MimicMachine.png", RelicTier.RARE, LandingSound.FLAT, 5);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new MachineActivateAction(getRandomMachine()));
    }
}
