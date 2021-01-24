package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class RechargerDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(RechargerDrone.class.getSimpleName());

    public RechargerDrone() {
        super(ID, "RechargerDrone.png", "RechargerDrone.png", RelicTier.SHOP, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, 1));
    }
}
