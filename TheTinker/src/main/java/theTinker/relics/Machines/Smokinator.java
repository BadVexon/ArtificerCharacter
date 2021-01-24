package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;
import theTinker.TinkerMod;
import theTinker.actions.MachineActivateAction;

public class Smokinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Smokinator.class.getSimpleName());

    public Smokinator() {
        super(ID, "Smokinator.png", "Placeholder.png", RelicTier.SHOP, LandingSound.FLAT, 2);
    }

    @Override
    public void onRightClick() {
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT && !(AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss)) {
            this.flash();
            this.counter--;
            atb(new MachineActivateAction(this));
        }
    }

    @Override
    public void activate(AbstractPlayer p) {
        AbstractDungeon.getCurrRoom().smoked = true;// 33
        atb(new VFXAction(new SmokeBombEffect(p.hb.cX, p.hb.cY)));// 34
        AbstractDungeon.player.hideHealthBar();// 35
        AbstractDungeon.player.isEscaping = true;// 36
        AbstractDungeon.player.flipHorizontal = !AbstractDungeon.player.flipHorizontal;// 37
        AbstractDungeon.overlayMenu.endTurnButton.disable();// 38
        AbstractDungeon.player.escapeTimer = 2.5F;// 39
    }
}
