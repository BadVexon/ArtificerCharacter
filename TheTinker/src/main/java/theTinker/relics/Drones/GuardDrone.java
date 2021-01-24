package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class GuardDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(GuardDrone.class.getSimpleName());

    public GuardDrone() {
        super(ID, "GuardDrone.png", "GuardDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, 2));
    }
}
