package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Tools.AbstractTool;

public class Energinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Energinator.class.getSimpleName());

    public Energinator() {
        super(ID, "Energinator.png", "Energinator.png", RelicTier.COMMON, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r instanceof AbstractTool) {
                r.counter -= 1;
            }
        }
    }
}
