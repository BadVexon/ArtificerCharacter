package theTinker.relics.Machines;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Stuninator extends AbstractMachine implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Stuninator.class.getSimpleName());

    public Stuninator() {
        super(ID, "Stuninator.png", "Placeholder.png", RelicTier.BOSS, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new StunMonsterAction(target, adp()));
    }
}
