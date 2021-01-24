package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import theTinker.TinkerMod;

public class SwordLauncher extends AbstractTool {
    public static String ID = TinkerMod.makeID(SwordLauncher.class.getSimpleName());

    public SwordLauncher() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.STARTER, LandingSound.FLAT, 3, 10);
    }

    public void activate(AbstractPlayer p) {
        atb(new DamageAction(frontMonster(), makeInfo(magic), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 3;
    }
}
