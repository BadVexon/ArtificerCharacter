package theTinker.relics.Drones;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.actions.ToolActivateAction;
import theTinker.relics.Tools.AbstractTool;

public class MastermindDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(MastermindDrone.class.getSimpleName());

    public MastermindDrone() {
        super(ID, "MastermindDrone.png", "MastermindDrone.png", RelicTier.SHOP, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        for (int i = 0; i < 2; i++) {
            AbstractRelic r = getRandomHotTool();
            if (r != null) {
                r.flash();
                r.counter -= Math.min(r.counter, 2);
            }
        }
        for (AbstractRelic q : adp().relics) {
            if (q instanceof AbstractTool && q.counter == 0) {
                q.stopPulse();
                q.counter = ((AbstractTool) q).cooldown;
                atb(new ToolActivateAction(q));
            }
        }
    }
}
