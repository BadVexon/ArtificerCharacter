package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.actions.DroneActivateAction;
import theTinker.relics.Drones.AbstractDrone;

public class DroneBlastinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(DroneBlastinator.class.getSimpleName());

    public DroneBlastinator() {
        super(ID, "DroneBlastinator.png", "DroneBlastinator.png", RelicTier.RARE, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r instanceof AbstractDrone) {
                atb(new DroneActivateAction(r));
                atb(new WaitAction(0.1F));
                atb(new DroneActivateAction(r));
                atb(new WaitAction(0.1F));
            }
        }
    }
}
