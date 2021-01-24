package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class FlameDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(FlameDrone.class.getSimpleName());

    public FlameDrone() {
        super(ID, "FlameDrone.png", "FlameDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAllEnemiesAction(p, DamageInfo.createDamageMatrix(2, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
    }
}
