package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class ShieldOTron extends AbstractTool {
    public static String ID = TinkerMod.makeID(ShieldOTron.class.getSimpleName());

    public ShieldOTron() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON,  LandingSound.FLAT, 3, 6);
    }

    public void activate(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, magic));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 2;
    }
}
