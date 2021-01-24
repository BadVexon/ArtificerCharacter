package theTinker.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import theTinker.util.SingleTargetRelic;

public class TargetEnemyAction extends AbstractGameAction {
    private VexTargetAction action;

    public TargetEnemyAction(SingleTargetRelic r) {
        action = new VexTargetAction(r);
    }

    public void update() {
        if (action.isDone) {
            this.isDone = true;
        }
    }
}
