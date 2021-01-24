package theTinker.relics.Machines;

import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import theTinker.actions.MachineActivateAction;
import theTinker.relics.AbstractTinkerRelic;

public abstract class AbstractMachine extends AbstractTinkerRelic implements ClickableRelic {
    public int charges;

    public AbstractMachine(String id, String texture, String outline, RelicTier tier, LandingSound sound, int baseOverdrives) {
        super(id, texture, "MachineTemplate.png", tier, sound);
        this.counter = baseOverdrives;
        this.charges = baseOverdrives;
    }

    public void onRightClick() {
        if (this.counter > 0 && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            this.flash();
            this.counter--;
            atb(new MachineActivateAction(this));
        }
    }

    public abstract void activate(AbstractPlayer p);
}
