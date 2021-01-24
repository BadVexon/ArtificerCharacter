package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class MiniTazer extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(MiniTazer.class.getSimpleName());

    public MiniTazer() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON, LandingSound.FLAT, 3, 9);
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new DamageAction(target, makeInfo(magic), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 3;
    }
}
