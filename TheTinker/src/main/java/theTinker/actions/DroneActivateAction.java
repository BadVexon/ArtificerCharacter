package theTinker.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.relics.Drones.AbstractDrone;

public class DroneActivateAction extends AbstractGameAction {
    private AbstractRelic wah;

    public DroneActivateAction(AbstractRelic r) {
        wah = r;
    }

    public void update() {
        AbstractDungeon.actionManager.addToBottom(new AbstractGameAction() {
            @Override
            public void update() {
                wah.flash();
                isDone = true;
            }
        });
        if (wah instanceof AbstractDrone) {
            ((AbstractDrone) wah).passive(AbstractDungeon.player);
        }
        this.isDone = true;
    }
}
