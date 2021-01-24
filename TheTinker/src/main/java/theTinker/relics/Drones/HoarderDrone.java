package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;
import theTinker.characters.TheTinker;

public class HoarderDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(HoarderDrone.class.getSimpleName());

    public HoarderDrone() {
        super(ID, "HoarderDrone.png", "HoarderDrone.png", RelicTier.BOSS, LandingSound.FLAT);
    }

    @Override
    public void onEquip() {
        if (AbstractDungeon.player instanceof TheTinker) {
            ((TheTinker) AbstractDungeon.player).droneSlots += 2;
            ((TheTinker) AbstractDungeon.player).machineSlots += 2;
            ((TheTinker) AbstractDungeon.player).toolSlots += 2;
        }
    }

    public void onUnequip() {
        if (AbstractDungeon.player instanceof TheTinker) {
            ((TheTinker) AbstractDungeon.player).droneSlots -= 2;
            ((TheTinker) AbstractDungeon.player).machineSlots -= 2;
            ((TheTinker) AbstractDungeon.player).toolSlots -= 2;
        }
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(frontMonster(), makeInfo(1), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
}
