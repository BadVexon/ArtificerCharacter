package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class Reducer extends AbstractTool {
    public static String ID = TinkerMod.makeID(Reducer.class.getSimpleName());

    public Reducer() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON, LandingSound.FLAT, 3);
    }

    public void activate(AbstractPlayer p) {
        AbstractRelic blah = getRandomHotTool();
        if (blah != null) {
            blah.counter -= Math.min(blah.counter, 2);
            blah.flash();
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        baseCooldown -= 1;
    }
}
