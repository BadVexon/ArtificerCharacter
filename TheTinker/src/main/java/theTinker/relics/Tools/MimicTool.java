package theTinker.relics.Tools;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;
import theTinker.actions.ToolActivateAction;

public class MimicTool extends AbstractTool {
    public static String ID = TinkerMod.makeID(MimicTool.class.getSimpleName());

    public MimicTool() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.RARE, LandingSound.FLAT, 3);
    }

    public void activate(AbstractPlayer p) {
        atb(new ToolActivateAction(getRandomTool()));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        baseCooldown -= 1;
    }
}
