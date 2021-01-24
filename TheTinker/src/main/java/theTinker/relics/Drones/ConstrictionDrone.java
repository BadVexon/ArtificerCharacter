package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.ConstrictedPower;
import theTinker.TinkerMod;

public class ConstrictionDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(ConstrictionDrone.class.getSimpleName());

    public ConstrictionDrone() {
        super(ID, "ConstrictionDrone.png", "ConstrictionDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new ApplyPowerAction(frontMonster(), p, new ConstrictedPower(frontMonster(), p, 1), 1));
    }
}
