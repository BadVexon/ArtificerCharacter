package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;

public class Confusionator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Confusionator.class.getSimpleName());

    public Confusionator() {
        super(ID, "Confusionator.png", "Confusionator.png", RelicTier.COMMON, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        for (AbstractMonster q : monsterlist()) {
            atb(new ApplyPowerAction(q, p, new WeakPower(q, 2, false), 2));
        }
    }
}
