package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import theTinker.TinkerMod;

public class GhostSuit extends AbstractTool {
    public static String ID = TinkerMod.makeID(GhostSuit.class.getSimpleName());

    public GhostSuit() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.BOSS, LandingSound.FLAT, 6);
    }

    public void activate(AbstractPlayer p) {
        atb(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, 1), 1));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        baseCooldown -= 1;
    }
}
