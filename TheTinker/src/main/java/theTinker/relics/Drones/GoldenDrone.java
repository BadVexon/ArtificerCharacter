package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.RainingGoldEffect;
import theTinker.TinkerMod;

public class GoldenDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(GoldenDrone.class.getSimpleName());

    public GoldenDrone() {
        super(ID, "GoldenDrone.png", "GoldenDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageRandomEnemyAction(makeInfo(1), AbstractGameAction.AttackEffect.FIRE));
    }

    public void onMonsterDeath(AbstractMonster m) {
        AbstractDungeon.effectList.add(new RainingGoldEffect(5));
        AbstractDungeon.player.gainGold(5);
    }
}
