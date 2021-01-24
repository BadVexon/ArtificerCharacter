package theTinker.relics.Drones;

import com.evacipated.cardcrawl.mod.stslib.relics.BetterOnLoseHpRelic;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class ShieldDrone extends AbstractDrone implements BetterOnLoseHpRelic {
    public static String ID = TinkerMod.makeID(ShieldDrone.class.getSimpleName());

    public ShieldDrone() {
        super(ID, "ShieldDrone.png", "ShieldDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    public int betterOnLoseHp(DamageInfo info, int damageAmount) {
        return damageAmount - 1;
    }

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(1), AbstractGameAction.AttackEffect.FIRE));
    }
}
