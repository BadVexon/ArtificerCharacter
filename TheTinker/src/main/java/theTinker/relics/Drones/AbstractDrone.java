package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.actions.DroneActivateAction;
import theTinker.relics.AbstractTinkerRelic;

public abstract class AbstractDrone extends AbstractTinkerRelic {

    public AbstractDrone(String id, String texture, String outline, RelicTier tier, LandingSound sound) {
        super(id, texture, outline, tier, sound);
    }

    /*
    THE BIG RARITY HELPER LIST:
    STARTER: IDX-56
    COMMON: IDX-45
    UNCOMMON: IDX-72
    RARE: IDX-100
    SHOP: IDX-95
    BOSS: IDX-6
    */

    public void atTurnStartPostDraw() {
        atb(new DroneActivateAction(this));
        atb(new WaitAction(0.1F));
    }

    public abstract void passive(AbstractPlayer p);
}
