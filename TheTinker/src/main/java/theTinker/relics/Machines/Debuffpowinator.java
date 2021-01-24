package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.Tools.AbstractTool;

public class Debuffpowinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Debuffpowinator.class.getSimpleName());

    public Debuffpowinator() {
        super(ID, "Debuffpowinator.png", "Debuffpowinator.png", RelicTier.UNCOMMON, LandingSound.FLAT, 3);
    }

    @Override
    public void activate(AbstractPlayer p) {
        for (AbstractMonster q : monsterlist()) {
            atb(new ApplyPowerAction(q, p, new WeakPower(q, 1, false), 1));
        }
        AbstractRelic r = getRandomTool();
        if (r != null) {
            r.flash();
            r.counter -= 1;
        }
    }
}
