package theTinker.relics.Drones;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class TechieDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(TechieDrone.class.getSimpleName());

    public TechieDrone() {
        super(ID, "TechieDrone.png", "TechieDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        AbstractRelic r = getHottestTool();
        if (r != null) {
            r.flash();
            r.counter -= Math.min(r.counter, 2);
        }
    }
}
