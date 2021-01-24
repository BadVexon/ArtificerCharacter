package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Tools.AbstractTool;

public class ChargerDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(ChargerDrone.class.getSimpleName());

    public ChargerDrone() {
        super(ID, "ChargerDrone.png", "ChargerDrone.png", RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    @Override
    public void onEnterRestRoom() {
        this.flash();
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r instanceof AbstractTool) {
                r.flash();
                r.counter = 0;
            }
        }
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(frontMonster(), makeInfo(1), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }
}
