package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;

public class Punchometer extends AbstractTool {
    public static String ID = TinkerMod.makeID(Punchometer.class.getSimpleName());

    public Punchometer() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON, LandingSound.FLAT, 4, 5);
    }

    public void activate(AbstractPlayer p) {
        atb(new ApplyPowerAction(frontMonster(), p, new WeakPower(frontMonster(), 1, false), 1));
        atb(new DamageAction(frontMonster(), makeInfo(magic), AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 3;
    }
}
