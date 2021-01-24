package theTinker.relics.Drones;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerToRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.PoisonPower;
import theTinker.TinkerMod;

public class FighterDrone2 extends AbstractDrone {
    public static String ID = TinkerMod.makeID(FighterDrone2.class.getSimpleName());
    private boolean mode = false;

    public FighterDrone2() {
        super(ID, "FighterDrone2.png", "FighterDrone2.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        if (mode) {
            atb(new ApplyPowerToRandomEnemyAction(p, new PoisonPower(null, p, 2), 2));
        } else {
            atb(new AddTemporaryHPAction(p, p, 2));
        }
        mode = !mode;
    }
}
