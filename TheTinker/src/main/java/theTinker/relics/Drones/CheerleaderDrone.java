package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class CheerleaderDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(CheerleaderDrone.class.getSimpleName());

    public CheerleaderDrone() {
        super(ID, "CheerleaderDrone.png", "CheerleaderDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, 1));
    }
}
