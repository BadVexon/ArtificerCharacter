package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.actions.DroneActivateAction;
import theTinker.characters.TheTinker;

public class DroneLeader extends AbstractDrone {
    public static String ID = TinkerMod.makeID(DroneLeader.class.getSimpleName());

    public DroneLeader() {
        super(ID, "DroneLeader.png", "DroneLeader.png", RelicTier.BOSS, LandingSound.FLAT);
    }

    @Override
    public void onEquip() {
        if (AbstractDungeon.player instanceof TheTinker) {
            ((TheTinker) AbstractDungeon.player).droneSlots++;
        }
    }

    public void onUnequip() {
        if (AbstractDungeon.player instanceof TheTinker) {
            ((TheTinker) AbstractDungeon.player).droneSlots--;
        }
    }

    public void passive(AbstractPlayer p) {
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r instanceof AbstractDrone && !(r instanceof DroneLeader)) {
                atb(new DroneActivateAction(r));
                atb(new WaitAction(0.1F));
            }
        }
    }
}
