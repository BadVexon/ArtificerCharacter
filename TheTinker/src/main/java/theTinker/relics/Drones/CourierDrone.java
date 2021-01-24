package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;
import theTinker.characters.TheTinker;

public class CourierDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(CourierDrone.class.getSimpleName());

    public CourierDrone() {
        super(ID, "CourierDrone.png", "CourierDrone.png", RelicTier.SHOP, LandingSound.FLAT);
    }

    @Override
    public void onEquip() {
        if (AbstractDungeon.player instanceof TheTinker) {
            ((TheTinker) AbstractDungeon.player).droneSlots++;
            ((TheTinker) AbstractDungeon.player).machineSlots++;
            ((TheTinker) AbstractDungeon.player).toolSlots++;
        }
    }

    public void onUnequip() {
        if (AbstractDungeon.player instanceof TheTinker) {
            ((TheTinker) AbstractDungeon.player).droneSlots--;
            ((TheTinker) AbstractDungeon.player).machineSlots--;
            ((TheTinker) AbstractDungeon.player).toolSlots--;
        }
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(frontMonster(), makeInfo(1), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
}
