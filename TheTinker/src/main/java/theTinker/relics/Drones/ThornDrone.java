package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.ThornsPower;
import theTinker.TinkerMod;

public class ThornDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(ThornDrone.class.getSimpleName());

    public ThornDrone() {
        super(ID, "ThornDrone.png", "ThornDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void atBattleStart() {
        this.flash();// 23
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ThornsPower(AbstractDungeon.player, 2), 2));// 24
    }// 30


    public void passive(AbstractPlayer p) {
        atb(new DamageRandomEnemyAction(makeInfo(1), AbstractGameAction.AttackEffect.FIRE));
    }


}
