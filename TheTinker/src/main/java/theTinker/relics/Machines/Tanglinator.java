package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConstrictedPower;
import theTinker.TinkerMod;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;

public class Tanglinator extends AbstractMachine implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(Tanglinator.class.getSimpleName());

    public Tanglinator() {
        super(ID, "Tanglinator.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 5);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        atb(new ApplyPowerAction(target, AbstractDungeon.player, new ConstrictedPower(target, AbstractDungeon.player, 4), 4));
    }
}
