package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class MultiTool extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(MultiTool.class.getSimpleName());

    public MultiTool() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.STARTER, LandingSound.FLAT, 2, 6);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    @Override
    public void onTargetChosen(AbstractMonster target) {
        atb(new DamageAction(target, makeInfo(magic), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        atb(new GainBlockAction(adp(), adp(), magic));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.magic + DESCRIPTIONS[2] + this.cooldown + DESCRIPTIONS[3];
    }

    public void callUpgrade() {
        magic += 2;
    }
}
