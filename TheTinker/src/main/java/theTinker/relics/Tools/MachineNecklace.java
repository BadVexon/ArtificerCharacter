package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Machines.AbstractMachine;

public class MachineNecklace extends AbstractTool {
    public static String ID = TinkerMod.makeID(MachineNecklace.class.getSimpleName());

    public MachineNecklace() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.BOSS, LandingSound.FLAT, 10);
    }

    public void activate(AbstractPlayer p) {
        for (AbstractRelic r : adp().relics) {
            if (r instanceof AbstractMachine) {
                r.flash();
                r.counter++;
            }
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        baseCooldown -= 2;
    }
}
