package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.actions.DroneActivateAction;
import theTinker.actions.MachineActivateAction;
import theTinker.actions.ToolActivateAction;

import java.util.ArrayList;

public class Amongator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Amongator.class.getSimpleName());

    public Amongator() {
        super(ID, "Amongator.png", "Amongator.png", RelicTier.SHOP, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new ToolActivateAction(getRandomTool()));
        atb(new DroneActivateAction(getRandomDrone()));
        ArrayList<AbstractRelic> relicList = new ArrayList<>();
        for (AbstractRelic r : p.relics) {
            if (r instanceof AbstractMachine && r != this) {
                relicList.add(r);
            }
        }
        if (!relicList.isEmpty()) {
            atb(new MachineActivateAction(relicList.get(AbstractDungeon.cardRandomRng.random(relicList.size() - 1))));
        }
    }
}
