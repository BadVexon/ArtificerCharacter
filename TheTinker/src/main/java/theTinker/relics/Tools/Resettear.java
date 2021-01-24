package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class Resettear extends AbstractTool {
    public static String ID = TinkerMod.makeID(Resettear.class.getSimpleName());

    public Resettear() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.RARE, LandingSound.FLAT, 4);
    }

    public void activate(AbstractPlayer p) {
        AbstractRelic blah = getRandomHotTool();
        if (blah != null) {
            blah.counter = 0;
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
