package theTinker.relics.Drones;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Tools.AbstractTool;

public class ToolmasterDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(ToolmasterDrone.class.getSimpleName());

    public ToolmasterDrone() {
        super(ID, "ToolmasterDrone.png", "ToolmasterDrone.png", RelicTier.BOSS, LandingSound.FLAT);
    }

    public void atBattleStart() {
        for (AbstractRelic r : adp().relics) {
            if (r instanceof AbstractTool) {
                ((AbstractTool) r).cooldown--;
            }
        }
    }

    public void passive(AbstractPlayer p) {
    }
}
