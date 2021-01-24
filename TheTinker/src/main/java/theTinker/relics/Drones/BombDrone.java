package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class BombDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(BombDrone.class.getSimpleName());

    public BombDrone() {
        super(ID, "BombDrone.png", "BombDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(frontMonster(), makeInfo(2), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        atb(new DamageAllEnemiesAction(p, DamageInfo.createDamageMatrix(1, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
    }
}
