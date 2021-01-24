package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Megacharginator extends AbstractMachine implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Megacharginator.class.getSimpleName());

    public Megacharginator() {
        super(ID, "Megacharginator.png", "Megacharginator.png", RelicTier.COMMON, LandingSound.FLAT, 4);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new DamageAction(target, makeInfo(7), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        AbstractRelic r = getRandomHotTool();
        if (r != null) {
            r.flash();
            r.counter -= 1;
        }
    }
}
