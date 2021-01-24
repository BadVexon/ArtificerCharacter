package theTinker.relics.Drones;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.evacipated.cardcrawl.mod.stslib.patches.core.AbstractCreature.TempHPField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class FingerOfDeathDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(FingerOfDeathDrone.class.getSimpleName());

    public FingerOfDeathDrone() {
        super(ID, "FingerOfDeathDrone.png", "FingerOfDeathDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    @Override
    public void atBattleStart() {
        this.flash();
        atb(new AddTemporaryHPAction(AbstractDungeon.player, AbstractDungeon.player, 4));
    }

    public void passive(AbstractPlayer p) {
        if (TempHPField.tempHp.get(p) > 0) {
            atb(new DamageRandomEnemyAction(makeInfo(TempHPField.tempHp.get(p)), AbstractGameAction.AttackEffect.FIRE));
        }
    }
}
