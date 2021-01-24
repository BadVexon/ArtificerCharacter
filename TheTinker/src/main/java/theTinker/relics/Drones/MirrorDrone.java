package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theTinker.TinkerMod;

public class MirrorDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(MirrorDrone.class.getSimpleName());

    public MirrorDrone() {
        super(ID, "MirrorDrone.png", "MirrorDrone.png", RelicTier.RARE, LandingSound.FLAT);
    }

    public void passive(AbstractPlayer p) {
        atb(new GainBlockAction(p, p, 1));
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.owner != null && info.type == DamageInfo.DamageType.NORMAL) {
            AbstractDungeon.actionManager.addToTop(new DamageAction(info.owner, new DamageInfo(AbstractDungeon.player, ((AbstractMonster) info.owner).getIntentDmg() / 2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
        }
        return damageAmount;
    }

}
