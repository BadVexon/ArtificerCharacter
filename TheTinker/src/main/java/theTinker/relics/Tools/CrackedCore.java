package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.defect.IncreaseMaxOrbAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Lightning;
import theTinker.TinkerMod;

public class CrackedCore extends AbstractTool {
    public static String ID = TinkerMod.makeID(CrackedCore.class.getSimpleName());

    public CrackedCore() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.RARE, LandingSound.FLAT, 5);
    }

    public void atBattleStart() {
        this.flash();// 29
        AbstractDungeon.actionManager.addToBottom(new IncreaseMaxOrbAction(3));// 31
    }

    public void activate(AbstractPlayer p) {
        atb(new ChannelAction(new Lightning()));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.cooldown + DESCRIPTIONS[1];
    }

    public void callUpgrade() {
        baseCooldown -= 1;
    }
}
