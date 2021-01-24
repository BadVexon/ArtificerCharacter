package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class TheRealCannon extends AbstractTool {
    public static String ID = TinkerMod.makeID(TheRealCannon.class.getSimpleName());

    public TheRealCannon() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.BOSS, LandingSound.FLAT, 10, 33);
    }

    public void activate(AbstractPlayer p) {
        atb(new DamageAllEnemiesAction(p, DamageInfo.createDamageMatrix(magic, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        baseCooldown -= 2;
    }
}
