package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class CardBlaster extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(CardBlaster.class.getSimpleName());

    public CardBlaster() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.RARE, LandingSound.FLAT, 5, 8);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster m) {
        atb(new DamageAction(m, makeInfo(magic), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        atb(new AddStolenCardAction(upgraded));
    }

    public String getUpdatedDescription() {
        if (upgraded) {
            return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[2] + this.cooldown + DESCRIPTIONS[3];
        } else {
            return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[3];
        }
    }

    public void callUpgrade() {
        magic += 2;
    }
}
