package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import theTinker.TinkerMod;

public class GuardianDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(GuardianDrone.class.getSimpleName());

    public GuardianDrone() {
        super(ID, "GuardianDrone.png", "GuardianDrone.png", RelicTier.SHOP, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new ApplyPowerAction(p, p, new ArtifactPower(p, 1), 1));
    }
}
