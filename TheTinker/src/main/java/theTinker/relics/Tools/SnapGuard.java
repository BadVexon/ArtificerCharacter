package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class SnapGuard extends AbstractTool {
    public static String ID = TinkerMod.makeID(SnapGuard.class.getSimpleName());

    public SnapGuard() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.STARTER, LandingSound.FLAT, 3, 4);
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
