package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Hecklinator extends AbstractMachine implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Hecklinator.class.getSimpleName());

    public Hecklinator() {
        super(ID, "Hecklinator.png", "Hecklinator.png", RelicTier.COMMON, LandingSound.FLAT, 4);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new DamageAction(target, makeInfo(5), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        atb(new ApplyPowerAction(target, AbstractDungeon.player, new WeakPower(target, 1, false), 1));
    }
}
