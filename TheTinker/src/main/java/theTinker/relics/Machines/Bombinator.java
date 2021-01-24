package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class Bombinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Bombinator.class.getSimpleName());

    public Bombinator() {
        super(ID, "Bombinator.png", "Bombinator.png", RelicTier.STARTER, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new DamageAllEnemiesAction(p, DamageInfo.createDamageMatrix(10, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }
}
