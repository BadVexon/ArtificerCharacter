package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class GoldTossinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(GoldTossinator.class.getSimpleName());

    public GoldTossinator() {
        super(ID, "GoldTossinator.png", "GoldTossinator.png", RelicTier.RARE, LandingSound.FLAT, 8);
    }

    @Override
    public void activate(AbstractPlayer p) {
        p.loseGold(24);
        atb(new DamageAllEnemiesAction(p, DamageInfo.createDamageMatrix(12, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }
}
