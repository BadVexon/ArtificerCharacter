package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theTinker.TinkerMod;

public class Debuffinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Debuffinator.class.getSimpleName());

    public Debuffinator() {
        super(ID, "Debuffinator.png", "Debuffinator.png", RelicTier.UNCOMMON, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        for (AbstractMonster q : monsterlist()) {
            atb(new ApplyPowerAction(q, p, new StrengthPower(q, -1), -1));
        }
    }
}
