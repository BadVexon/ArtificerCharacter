package theTinker.relics.Drones;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class PreventionDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(PreventionDrone.class.getSimpleName());

    public PreventionDrone() {
        super(ID, "PreventionDrone.png", "PreventionDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void atBattleStart() {
        this.flash();
        atb(new AddTemporaryHPAction(AbstractDungeon.player, AbstractDungeon.player, 2));
    }

    public void passive(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, 1));
    }
}
