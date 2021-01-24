package theTinker.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.relics.Machines.AbstractMachine;
import theTinker.relics.Tools.AbstractTool;

public class MachineActivateAction extends AbstractGameAction {
    private AbstractRelic wah;

    public MachineActivateAction(AbstractRelic r) {
        wah = r;
    }

    public void update() {
        if (wah instanceof AbstractMachine) {
            wah.flash();
            ((AbstractMachine) wah).activate(AbstractDungeon.player);
        }
        this.isDone = true;
    }
}
