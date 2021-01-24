package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class SadnessSpray extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(SadnessSpray.class.getSimpleName());

    public SadnessSpray() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 8, 8);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster q) {
        if (!q.isDying && !q.isDead) {
            atb(new ApplyPowerAction(q, AbstractDungeon.player, new StrengthPower(q, -magic), -magic));
            if (!q.hasPower(ArtifactPower.POWER_ID)) {
                atb(new ApplyPowerAction(q, AbstractDungeon.player, new GainStrengthPower(q, magic), magic));
            }
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 4;
    }
}
