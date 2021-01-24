package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class IronWavinator extends AbstractMachine implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(IronWavinator.class.getSimpleName());

    public IronWavinator() {
        super(ID, "IronWavinator.png", "IronWavinator.png", RelicTier.COMMON, LandingSound.FLAT, 6);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, 5));
        atb(new DamageAction(target, makeInfo(5), AbstractGameAction.AttackEffect.FIRE));
    }
}
