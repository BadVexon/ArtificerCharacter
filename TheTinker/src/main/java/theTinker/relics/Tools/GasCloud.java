package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import theTinker.TinkerMod;

public class GasCloud extends AbstractTool {
    public static String ID = TinkerMod.makeID(GasCloud.class.getSimpleName());

    public GasCloud() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 3, 4);
    }

    public void activate(AbstractPlayer p) {
        AbstractMonster q = AbstractDungeon.getRandomMonster();
        atb(new ApplyPowerAction(q, p, new PoisonPower(q, p, magic), magic));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
baseCooldown -= 1;
    }
}
