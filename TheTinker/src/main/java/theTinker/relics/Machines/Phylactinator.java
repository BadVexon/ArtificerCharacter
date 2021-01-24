package theTinker.relics.Machines;

import com.evacipated.cardcrawl.mod.stslib.relics.OnPlayerDeathRelic;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Phylactinator extends AbstractMachine implements SingleTargetRelic, OnPlayerDeathRelic {
    public static String ID = TinkerMod.makeID(Phylactinator.class.getSimpleName());

    public Phylactinator() {
        super(ID, "Phylactinator.png", "Phylactinator.png", RelicTier.RARE, LandingSound.FLAT, 15);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public boolean onPlayerDeath(AbstractPlayer p, DamageInfo info) {
        for (int i = 0; i < info.output; i++) {
            if (this.counter > 0) {
                this.counter -= 1;
            }
        }
        return this.counter <= 0;
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new DamageAction(target, makeInfo(2), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }
}
