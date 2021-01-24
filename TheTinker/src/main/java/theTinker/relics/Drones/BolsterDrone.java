package theTinker.relics.Drones;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class BolsterDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(BolsterDrone.class.getSimpleName());

    public BolsterDrone() {
        super(ID, "BolsterDrone.png", "BolsterDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new AddTemporaryHPAction(p, p, 1));
    }
}
