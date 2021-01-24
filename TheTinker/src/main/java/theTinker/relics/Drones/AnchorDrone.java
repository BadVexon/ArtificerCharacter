package theTinker.relics.Drones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theTinker.TinkerMod;

public class AnchorDrone extends AbstractDrone {
    public static String ID = TinkerMod.makeID(AnchorDrone.class.getSimpleName());

    public AnchorDrone() {
        super(ID, "AnchorDrone.png", "AnchorDrone.png", RelicTier.COMMON, LandingSound.FLAT);
    }

    public void atBattleStart() {
        this.flash();// 22
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, 5));// 24
    }// 26

    public void passive(AbstractPlayer p) {
        atb(new DamageAction(AbstractDungeon.getRandomMonster(), makeInfo(1), AbstractGameAction.AttackEffect.FIRE));
    }
}
