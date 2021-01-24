package theTinker.relics.Machines;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class Sandblastinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(Sandblastinator.class.getSimpleName());

    public Sandblastinator() {
        super(ID, "Sandblastinator.png", "Placeholder.png", RelicTier.SHOP, LandingSound.FLAT, 2);
    }

    @Override
    public void activate(AbstractPlayer p) {
        atb(new StunMonsterAction(AbstractDungeon.getRandomMonster(), p));
    }
}
