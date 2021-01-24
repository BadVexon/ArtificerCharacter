package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theTinker.TinkerMod;

public class PesterDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(PesterDrone.class.getSimpleName());

    public PesterDrone() {
        super(ID, "PesterDrone.png", "PesterDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        AbstractMonster m = AbstractDungeon.getRandomMonster();
        atb(new ApplyPowerAction(m, p, new StrengthPower(m, -1), -1));
        if (!m.hasPower(ArtifactPower.POWER_ID)) {
            atb(new ApplyPowerAction(m, p, new GainStrengthPower(m, 1), 1));
        }
    }
}
