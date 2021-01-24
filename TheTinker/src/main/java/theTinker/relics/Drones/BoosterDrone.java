package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Machines.AbstractMachine;

public class BoosterDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(BoosterDrone.class.getSimpleName());

    public BoosterDrone() {
        super(ID, "BoosterDrone.png", "BoosterDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    @Override
    public void onEnterRestRoom() {
        this.flash();
        AbstractRelic r = getRandomMachine();
        if (r != null) {
            r.flash();
            r.counter += 1;
        }
    }

    public void passive(AbstractPlayer p) {
        int blah = 0;
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r instanceof AbstractMachine && r.counter == 0) {
                blah++;
            }
        }
        if (blah > 0) {
            atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(blah), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        }
    }
}
