package theTinker.relics.Tools;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import theTinker.TinkerMod;

public class PortableCannonball extends AbstractTool {
    public static String ID = TinkerMod.makeID(PortableCannonball.class.getSimpleName());

    public PortableCannonball() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.COMMON,  LandingSound.FLAT, 5, 15);
    }

    public void activate(AbstractPlayer p) {
        atb(new DamageAction(backMonster(), makeInfo(magic), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.cooldown + DESCRIPTIONS[2];
    }

    public void callUpgrade() {
        magic += 5;
    }
}
