package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class FirstDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(FirstDrone.class.getSimpleName());

    public FirstDrone() {
        super(ID, "FirstDrone.png", "FirstDrone.png", RelicTier.STARTER, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(1), AbstractGameAction.AttackEffect.FIRE));
        atb(new GainBlockAction(p, p, 1));
    }
}
