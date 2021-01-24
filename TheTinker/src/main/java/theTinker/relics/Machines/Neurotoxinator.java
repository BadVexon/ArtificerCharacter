package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import theTinker.TinkerMod;

public class Neurotoxinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Neurotoxinator.class.getSimpleName());

    public Neurotoxinator() {
        super(ID, "Neurotoxinator.png", "Neurotoxinator.png", RelicTier.COMMON, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        for (AbstractMonster q : monsterlist()) {
            atb(new ApplyPowerAction(q, p, new PoisonPower(q, p, 5), 5));
        }
    }
}
