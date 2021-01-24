package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class TwoHandedWheel extends AbstractTool {
    public static String ID = TinkerMod.makeID(TwoHandedWheel.class.getSimpleName());

    public TwoHandedWheel() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.RARE, LandingSound.FLAT, 7);
    }

    public void activate(AbstractPlayer p) {
        atb(new AddStolenCardAction(false));
        atb(new AddStolenCardAction(false));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        cooldown -= 1;
    }
}
