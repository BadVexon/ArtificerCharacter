package theTinker.relics.Drones;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.DroneActivateAction;

public class MimicDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(MimicDrone.class.getSimpleName());

    public MimicDrone() {
        super(ID, "MimicDrone.png", "MimicDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DroneActivateAction(getRandomDrone()));
    }
}
