package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;

import java.util.ArrayList;

public class Megabuffer extends AbstractTool {
    public static String ID = TinkerMod.makeID(Megabuffer.class.getSimpleName());

    public Megabuffer() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.RARE, LandingSound.FLAT, 8);
    }

    public void activate(AbstractPlayer p) {
        ArrayList<AbstractRelic> blah = new ArrayList<>();
        for (AbstractRelic q : AbstractDungeon.player.relics) {
            if (q instanceof AbstractTool) {
                if (((AbstractTool) q).cooldown > 1) blah.add(q);
            }
        }
        AbstractRelic r = blah.get(AbstractDungeon.cardRandomRng.random(blah.size() - 1));
        if (r != null) {
            r.flash();
            ((AbstractTool) r).cooldown -= 1;
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        baseCooldown -= 2;
    }
}
