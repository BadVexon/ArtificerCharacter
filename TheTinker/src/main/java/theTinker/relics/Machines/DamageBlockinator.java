package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class DamageBlockinator extends AbstractMachine implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(DamageBlockinator.class.getSimpleName());

    public DamageBlockinator() {
        super(ID, "DamageBlockinator.png", "DamageBlockinator.png", RelicTier.BOSS, LandingSound.FLAT, 10);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new GainBlockAction(adp(), adp(), 10));
        atb(new DamageAction(target, makeInfo(10), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }
}
