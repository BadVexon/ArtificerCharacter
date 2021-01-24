package theTinker.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.relics.Drones.CheerleaderDrone;
import theTinker.relics.Tools.AbstractTool;

public class ToolActivateAction extends AbstractGameAction {
    private AbstractRelic wah;

    public ToolActivateAction(AbstractRelic r) {
        wah = r;
    }

    public void update() {
        if (wah instanceof AbstractTool) {
            wah.flash();
            ((AbstractTool) wah).activate(AbstractDungeon.player);
        }
        if (AbstractDungeon.player.hasRelic(CheerleaderDrone.ID)) {
            AbstractDungeon.player.getRelic(CheerleaderDrone.ID).flash();
            AbstractDungeon.actionManager.addToBottom(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, 1));
        }
        this.isDone = true;
    }
}
