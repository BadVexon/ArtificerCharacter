package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class StrikerDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(StrikerDrone.class.getSimpleName());

    public StrikerDrone() {
        super(ID, "StrikerDrone.png", "StrikerDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    @Override
    public void atBattleStart() {
        this.flash();
        atb(new DamageAction(frontMonster(), makeInfo(8), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(frontMonster(), makeInfo(2), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }
}
