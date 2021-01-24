package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

public class SafeReactor extends AbstractTool {
    public static String ID = TinkerMod.makeID(SafeReactor.class.getSimpleName());

    public SafeReactor() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.BOSS, LandingSound.FLAT, 6);
    }

    public void activate(AbstractPlayer p) {
        for (AbstractRelic r : adp().relics) {
            if (r instanceof AbstractTool && !(r instanceof SafeReactor)) {
                r.flash();
                r.counter = 0;
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
