package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;
import theTinker.actions.AnimateReverseGravityAction;

public class GravityLauncher extends AbstractTool {
    public static String ID = TinkerMod.makeID(GravityLauncher.class.getSimpleName());

    public GravityLauncher() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.RARE, LandingSound.FLAT, 8, 15);
    }

    public void activate(AbstractPlayer p) {
        atb(new AnimateReverseGravityAction());

        atb(new DamageAllEnemiesAction(p, DamageInfo.createDamageMatrix(magic, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        for (AbstractMonster mo : AbstractDungeon.getMonsters().monsters) {
            atb(new ApplyPowerAction(mo, p, new WeakPower(mo, 2, false), 1, true, AbstractGameAction.AttackEffect.NONE));
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 5;
    }
}
