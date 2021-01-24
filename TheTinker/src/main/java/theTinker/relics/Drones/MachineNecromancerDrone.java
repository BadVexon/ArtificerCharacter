package theTinker.relics.Drones;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.actions.MachineActivateAction;

public class MachineNecromancerDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(MachineNecromancerDrone.class.getSimpleName());

    public MachineNecromancerDrone() {
        super(ID, "MachineNecromancerDrone.png", "MachineNecromancerDrone.png", RelicTier.BOSS, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        AbstractRelic r = getRandomMachine();
        if (r != null) {
            atb(new MachineActivateAction(r));
        }
    }
}
