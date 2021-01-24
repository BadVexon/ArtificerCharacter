package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class SuppressionSpray extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(SuppressionSpray.class.getSimpleName());

    public SuppressionSpray() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.STARTER, LandingSound.FLAT, 4);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new ApplyPowerAction(target, AbstractDungeon.player, new WeakPower(target, 1, false), 1));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
baseCooldown -= 1;
    }
}
