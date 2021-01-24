package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import theTinker.TinkerMod;

public class PlatedArminator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(PlatedArminator.class.getSimpleName());

    public PlatedArminator() {
        super(ID, "PlatedArminator.png", "Placeholder.png", RelicTier.SHOP, LandingSound.FLAT, 4);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new ApplyPowerAction(p, p, new PlatedArmorPower(p, 2), 2));
    }
}
