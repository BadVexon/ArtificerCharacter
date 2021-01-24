package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class Adapter extends AbstractTool {
    public static String ID = TinkerMod.makeID(Adapter.class.getSimpleName());

    public Adapter() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.RARE, LandingSound.FLAT, 12);
    }

    public void activate(AbstractPlayer p) {
        AbstractRelic q = getRandomMachine();
        if (q != null) {
            q.flash();
            q.counter += 1;
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
baseCooldown -= 2;
    }
}
