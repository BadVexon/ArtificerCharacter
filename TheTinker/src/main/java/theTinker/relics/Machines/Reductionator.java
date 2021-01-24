package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Reductionator extends AbstractMachine implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Reductionator.class.getSimpleName());

    public Reductionator() {
        super(ID, "Reductionator.png", "Placeholder.png", RelicTier.COMMON, LandingSound.FLAT, 4);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new ApplyPowerAction(target, AbstractDungeon.player, new StrengthPower(target, -3), -3));
        if (!target.hasPower(ArtifactPower.POWER_ID)) {
            atb(new ApplyPowerAction(target, AbstractDungeon.player, new GainStrengthPower(target, 3), 3));
        }
    }
}
