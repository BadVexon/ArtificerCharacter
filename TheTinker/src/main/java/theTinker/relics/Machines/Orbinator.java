package theTinker.relics.Machines;

import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.defect.IncreaseMaxOrbAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.orbs.Lightning;
import theTinker.TinkerMod;

public class Orbinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Orbinator.class.getSimpleName());

    public Orbinator() {
        super(ID, "Orbinator.png", "Orbinator.png", RelicTier.RARE, LandingSound.FLAT, 4);
    }

    public void atBattleStart() {
        this.flash();// 29
        AbstractDungeon.actionManager.addToBottom(new IncreaseMaxOrbAction(3));// 31
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new ChannelAction(new Lightning()));
        atb(new ChannelAction(new Frost()));
    }
}
