package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Sapper extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Sapper.class.getSimpleName());

    public Sapper() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.SHOP, LandingSound.FLAT, 5);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster q) {
        if (!q.isDying && !q.isDead) {
            atb(new ApplyPowerAction(q, AbstractDungeon.player, new StrengthPower(q, -1), -1));
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        baseCooldown -= 1;
    }
}
