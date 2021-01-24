package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Whackaball extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Whackaball.class.getSimpleName());

    public Whackaball() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON, LandingSound.FLAT, 3, 6);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        int blah = magic;
        if (target.hasPower(WeakPower.POWER_ID))
        {
            blah += target.getPower(WeakPower.POWER_ID).amount * 2;
        }
        atb(new DamageAction(target, makeInfo(blah), AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 3;
    }
}
