package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class ScrapperDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(ScrapperDrone.class.getSimpleName());

    public ScrapperDrone() {
        super(ID, "ScrapperDrone.png", "ScrapperDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAllEnemiesAction(p, DamageInfo.createDamageMatrix(1, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
    }
}
