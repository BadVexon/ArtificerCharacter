package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;

public class LouseBGone extends AbstractTool {
    public static String ID = TinkerMod.makeID(LouseBGone.class.getSimpleName());

    public LouseBGone() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON, LandingSound.FLAT, 5);
    }

    public void activate(AbstractPlayer p) {
        for (AbstractMonster q : monsterlist()) {
            if (!q.isDying && !q.isDead) {
                atb(new ApplyPowerAction(q, p, new WeakPower(q, 1, false), 1));
            }
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
baseCooldown -= 1;
    }
}
