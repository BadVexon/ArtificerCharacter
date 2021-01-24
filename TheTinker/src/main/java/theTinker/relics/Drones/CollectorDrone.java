package theTinker.relics.Drones;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class CollectorDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(CollectorDrone.class.getSimpleName());

    public CollectorDrone() {
        super(ID, "CollectorDrone.png", "CollectorDrone.png", RelicTier.BOSS, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new AddStolenCardAction(false));
    }
}
