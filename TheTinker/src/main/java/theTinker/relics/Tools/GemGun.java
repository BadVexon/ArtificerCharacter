package theTinker.relics.Tools;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.Ectoplasm;
import com.megacrit.cardcrawl.vfx.RainingGoldEffect;
import theTinker.TinkerMod;
import theTinker.actions.ShootAnythingAction;
import theTinker.actions.TargetEnemyAction;
import theTinker.util.SingleTargetRelic;
import theTinker.util.TextureLoader;

public class GemGun extends AbstractTool implements SingleTargetRelic {
    public static String ID = TinkerMod.makeID(GemGun.class.getSimpleName());
    private boolean activated = false;

    public GemGun() {
        super(ID, "Placeholder.png", "Placeholder.png", RelicTier.UNCOMMON, LandingSound.FLAT, 4, 8);
    }

    @Override
    public void atBattleStart() {
        this.activated = false;
    }

    public void activate(AbstractPlayer p) {
        atb(new TargetEnemyAction(this));
    }

    public void onTargetChosen(AbstractMonster target) {
        if (!activated) {
            AbstractDungeon.player.gainGold(magic);
            if (!AbstractDungeon.player.hasRelic(Ectoplasm.ID)) {
                AbstractDungeon.effectList.add(new RainingGoldEffect(magic));
            }
            activated = true;
        }
        atb(new ShootAnythingAction(target, TextureLoader.getTexture("tinkerResources/images/ui/Gem" + MathUtils.random(1, 7) + ".png")));
        atb(new DamageAction(target, makeInfo(magic), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + this.magic + DESCRIPTIONS[1] + this.magic + DESCRIPTIONS[2] + this.cooldown + DESCRIPTIONS[3];
    }

    public void callUpgrade() {
        magic += 2;
    }
}
