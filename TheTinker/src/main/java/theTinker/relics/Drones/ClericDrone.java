package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class ClericDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(ClericDrone.class.getSimpleName());

    public ClericDrone() {
        super(ID, "ClericDrone.png", "ClericDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    @Override
    public void onVictory() {
        this.flash();// 19
        AbstractDungeon.player.increaseMaxHp(1, true);// 20
    }// 21

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(1), AbstractGameAction.AttackEffect.FIRE));
    }
}
