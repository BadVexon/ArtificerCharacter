package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class RefreshmentDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(RefreshmentDrone.class.getSimpleName());

    public RefreshmentDrone() {
        super(ID, "RefreshmentDrone.png", "RefreshmentDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    @Override
    public void onEnterRestRoom() {
        this.flash();
        AbstractDungeon.player.increaseMaxHp(2, true);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageRandomEnemyAction(makeInfo(2), AbstractGameAction.AttackEffect.FIRE));
    }
}
