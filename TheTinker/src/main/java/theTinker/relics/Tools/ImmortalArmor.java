package theTinker.relics.Tools;

import com.evacipated.cardcrawl.mod.stslib.relics.OnPlayerDeathRelic;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class ImmortalArmor extends AbstractTool implements OnPlayerDeathRelic {
    public static String ID = TinkerMod.makeID(ImmortalArmor.class.getSimpleName());

    public ImmortalArmor() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.BOSS, LandingSound.FLAT, 12);
    }

    public void activate(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, 5));
    }

    public boolean onPlayerDeath(AbstractPlayer p, DamageInfo info) {
        if (this.counter == 0) {
            this.flash();
            this.counter = this.cooldown;
            p.heal(1, true);
            return false;
        }
        return true;
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        baseCooldown -= 2;
    }
}
