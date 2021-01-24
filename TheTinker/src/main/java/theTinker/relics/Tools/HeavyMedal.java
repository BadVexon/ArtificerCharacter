package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.PowerTip;
import theTinker.TinkerMod;

public class HeavyMedal extends AbstractTool {
    public static String ID = TinkerMod.makeID(HeavyMedal.class.getSimpleName());

    public HeavyMedal() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON,  LandingSound.FLAT, 5, 10);
    }

    public void activate(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, magic));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 5;
    }
}
