package theTinker.relics.Tools;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Drainotron extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Drainotron.class.getSimpleName());

    public Drainotron() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 6, 8);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new DamageAction(target, makeInfo(magic), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        atb(new AddTemporaryHPAction(AbstractDungeon.player, AbstractDungeon.player, magic / 2));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + (this.magic / 2) + DESCRIPTIONS[2] + this.cooldown + DESCRIPTIONS[3];
    }

    public void callUpgrade() {
        magic += 2;
    }
}
