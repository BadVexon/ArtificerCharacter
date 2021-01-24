package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import theTinker.TinkerMod;

public class EmergencyShieldinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(EmergencyShieldinator.class.getSimpleName());

    public EmergencyShieldinator() {
        super(ID, "EmergencyShieldinator.png", "EmergencyShieldinator.png", RelicTier.RARE, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, 1), 1));
    }
}
