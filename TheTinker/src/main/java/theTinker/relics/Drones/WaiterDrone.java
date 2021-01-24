package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Tools.AbstractTool;

import java.util.ArrayList;

public class WaiterDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(WaiterDrone.class.getSimpleName());

    public WaiterDrone() {
        super(ID, "WaiterDrone.png", "WaiterDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, 2));
    }
}
