package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class CardPirater extends AbstractTool {
    public static String ID = TinkerMod.makeID(CardPirater.class.getSimpleName());

    public CardPirater() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 4);
    }

    public void activate(AbstractPlayer p) {
        atb(new AddStolenCardAction(this.upgraded));
    }

    public String getUpdatedDescription() {
        if (upgraded) {
            return DESCRIPTIONS[2] + this.cooldown + DESCRIPTIONS[1];
        } else {
            return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
        }
    }

    public void callUpgrade() {
    }
}
