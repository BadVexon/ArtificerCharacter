package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class AllRoundDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(AllRoundDrone.class.getSimpleName());

    public AllRoundDrone() {
        super(ID, "AllRoundDrone.png", "AllRoundDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(1), AbstractGameAction.AttackEffect.FIRE));
        atb(new GainBlockAction(p, p, 1));
        AbstractRelic r = getRandomHotTool();
        if (r != null) {
            r.flash();
            r.counter -= 1;
        }
    }
}
