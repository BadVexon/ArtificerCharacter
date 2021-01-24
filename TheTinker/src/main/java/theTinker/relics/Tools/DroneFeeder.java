package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Drones.AbstractDrone;

public class DroneFeeder extends AbstractTool {
    public static String ID = TinkerMod.makeID(DroneFeeder.class.getSimpleName());

    public DroneFeeder() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 3);
    }

    public void activate(AbstractPlayer p) {
        AbstractRelic r = getRandomDrone();
        if (r != null) {
            r.flash();
            ((AbstractDrone) r).passive(p);
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
baseCooldown -= 1;
    }
}
