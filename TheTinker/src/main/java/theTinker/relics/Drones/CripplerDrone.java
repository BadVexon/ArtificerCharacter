package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.ApplyPowerToRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;

public class CripplerDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(CripplerDrone.class.getSimpleName());

    public CripplerDrone() {
        super(ID, "CripplerDrone.png", "CripplerDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerToRandomEnemyAction(AbstractDungeon.player, new WeakPower(null, 1, false), 1));
    }
}
