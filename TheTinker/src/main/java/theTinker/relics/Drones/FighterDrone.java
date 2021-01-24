package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class FighterDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(FighterDrone.class.getSimpleName());
    private boolean mode = false;

    public FighterDrone() {
        super(ID, "FighterDrone.png", "FighterDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        if (mode) {
            atb(new DamageRandomEnemyAction(makeInfo(3), AbstractGameAction.AttackEffect.FIRE));
        } else {
            atb(new GainBlockAction(p, p, 3));
        }
        mode = !mode;
    }
}
