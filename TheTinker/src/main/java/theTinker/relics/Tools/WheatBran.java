package theTinker.relics.Tools;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class WheatBran extends AbstractTool {
    public static String ID = TinkerMod.makeID(WheatBran.class.getSimpleName());

    public WheatBran() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON,  LandingSound.FLAT, 4, 5);
    }

    public void activate(AbstractPlayer p) {
        atb(new AddTemporaryHPAction(p, p, magic));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 1;
    }
}
