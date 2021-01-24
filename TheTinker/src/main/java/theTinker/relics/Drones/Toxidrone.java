package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import theTinker.TinkerMod;

public class Toxidrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(Toxidrone.class.getSimpleName());

    public Toxidrone() {
        super(ID, "Toxidrone.png", "Toxidrone.png", RelicTier.BOSS, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            if (!m.isDead && !m.isDying) {// 30
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new PoisonPower(m, p, 2), 2));// 31
            }
        }
    }
}
