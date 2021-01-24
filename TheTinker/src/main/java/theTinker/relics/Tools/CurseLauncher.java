package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConstrictedPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class CurseLauncher extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(CurseLauncher.class.getSimpleName());

    public CurseLauncher() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 4, 4);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new ApplyPowerAction(target, AbstractDungeon.player, new ConstrictedPower(target, AbstractDungeon.player, magic), magic));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 1;
    }
}
