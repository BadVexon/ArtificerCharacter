package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theTinker.TinkerMod;

public class DazeBomb extends AbstractTool {
    public static String ID = TinkerMod.makeID(DazeBomb.class.getSimpleName());

    public DazeBomb() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON,  LandingSound.FLAT, 4, 4);
    }

    public void activate(AbstractPlayer p) {
        for (AbstractMonster q : monsterlist()) {
            if (!q.isDying && !q.isDead) {
                atb(new ApplyPowerAction(q, p, new StrengthPower(q, -magic), -magic));
                if (!q.hasPower(ArtifactPower.POWER_ID)) {
                    atb(new ApplyPowerAction(q, p, new GainStrengthPower(q, magic), magic));
                }
            }
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 2;
    }
}
