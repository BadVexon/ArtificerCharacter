package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class LifeTapper extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(LifeTapper.class.getSimpleName());

    public LifeTapper() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.SHOP  , LandingSound.FLAT, 0, 9);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    @Override
    public void onTargetChosen(AbstractMonster target) {
        adp().decreaseMaxHealth(magic);
        atb(new DamageAction(target, makeInfo(20), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic -= 3;
    }
}
