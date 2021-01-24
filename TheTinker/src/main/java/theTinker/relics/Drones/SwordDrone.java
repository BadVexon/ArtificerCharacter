package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class SwordDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(SwordDrone.class.getSimpleName());

    public SwordDrone() {
        super(ID, "SwordDrone.png", "SwordDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(frontMonster(), makeInfo(3), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }
}
