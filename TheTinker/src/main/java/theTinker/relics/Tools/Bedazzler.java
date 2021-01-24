package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Bedazzler extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Bedazzler.class.getSimpleName());

    public Bedazzler() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 5, 8);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new DamageAction(target, makeInfo(magic), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        if (upgraded) {
            atb(new ApplyPowerAction(target, AbstractDungeon.player, new WeakPower(target, 2, false), 2));
        } else {
            atb(new ApplyPowerAction(target, AbstractDungeon.player, new WeakPower(target, 2, false), 2));
        }
    }

    public String getUpdatedDescription() {
        if (upgraded) {
            return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
        } else {
            return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[3] + this.cooldown + DESCRIPTIONS[2];
        }
    }

    public void callUpgrade() {
        magic += 2;
    }
}
