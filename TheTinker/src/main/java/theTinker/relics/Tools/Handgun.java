package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class Handgun extends AbstractTool {
    public static String ID = TinkerMod.makeID(Handgun.class.getSimpleName());

    public Handgun() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON,  LandingSound.FLAT, 2, 3);
    }

    public void activate(AbstractPlayer p) {
        atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(magic), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 1;
    }
}
