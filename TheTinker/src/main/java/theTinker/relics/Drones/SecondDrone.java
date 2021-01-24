package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class SecondDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(SecondDrone.class.getSimpleName());

    public SecondDrone() {
        super(ID, "SecondDrone.png", "SecondDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(2), AbstractGameAction.AttackEffect.FIRE));
        atb(new GainBlockAction(p, p, 1));
    }
}
