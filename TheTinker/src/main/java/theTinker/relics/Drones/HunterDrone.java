package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class HunterDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(HunterDrone.class.getSimpleName());

    public HunterDrone() {
        super(ID, "HunterDrone.png", "HunterDrone.png", RelicTier.SHOP, LandingSound.FLAT);
    }

    public void onVictory() {
        AbstractDungeon.getCurrRoom().addGoldToRewards(10);
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(2), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }
}
