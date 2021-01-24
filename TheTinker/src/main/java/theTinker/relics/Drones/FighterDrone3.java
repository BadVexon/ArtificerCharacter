package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theTinker.TinkerMod;
import theTinker.actions.AddStolenCardAction;

public class FighterDrone3 extends AbstractDrone {
    public static String ID = TinkerMod.makeID(FighterDrone3.class.getSimpleName());
    private boolean mode = false;

    public FighterDrone3() {
        super(ID, "FighterDrone3.png", "FighterDrone3.png", RelicTier.RARE, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        if (mode) {
            atb(new AddStolenCardAction(false));
        } else {
            AbstractMonster m = AbstractDungeon.getRandomMonster();
            atb(new ApplyPowerAction(m, p, new StrengthPower(m, -2), -2));
            if (!m.hasPower(ArtifactPower.POWER_ID)) {
                atb(new ApplyPowerAction(m, p, new GainStrengthPower(m, 2), 2));
            }
        }
        mode = !mode;
    }
}
