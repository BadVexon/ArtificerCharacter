package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.actions.DroneActivateAction;
import theTinker.relics.Drones.AbstractDrone;

public class DroneDJ extends AbstractTool {
    public static String ID = TinkerMod.makeID(DroneDJ.class.getSimpleName());

    public DroneDJ() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 4);
    }

    public void activate(AbstractPlayer p) {
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r instanceof AbstractDrone) {
                atb(new DroneActivateAction(r));
                atb(new WaitAction(0.1F));
            }
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
baseCooldown -= 1;
    }
}
