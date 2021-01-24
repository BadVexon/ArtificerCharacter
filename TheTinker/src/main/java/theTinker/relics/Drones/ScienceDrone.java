package theTinker.relics.Drones;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class ScienceDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(ScienceDrone.class.getSimpleName());

    public ScienceDrone() {
        super(ID, "ScienceDrone.png", "ScienceDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        AbstractRelic r = getRandomHotTool();
        if (r != null) {
            r.flash();
            r.counter -= 1;
        }
    }
}
