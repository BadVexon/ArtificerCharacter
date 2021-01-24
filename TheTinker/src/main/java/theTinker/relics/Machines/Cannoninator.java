package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class Cannoninator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Cannoninator.class.getSimpleName());

    public Cannoninator() {
        super(ID, "Cannoninator.png", "Cannoninator.png", RelicTier.COMMON, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new DamageAction(backMonster(), makeInfo(15), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }
}
