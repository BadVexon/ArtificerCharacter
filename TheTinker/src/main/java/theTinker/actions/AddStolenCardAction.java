package theTinker.actions;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.cards.red.*;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ModHelper;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDiscardEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToHandEffect;
import theTinker.util.BardHelper;
import theTinker.util.ThortonHelper;

import java.util.ArrayList;

public class AddStolenCardAction extends AbstractGameAction {
    private boolean upgraded;

    public AddStolenCardAction(boolean upgrade) {
        duration = Settings.ACTION_DUR_XFAST;
        actionType = ActionType.WAIT;
        upgraded = upgrade;
    }

    public void update() {
        ArrayList<AbstractCard> stolenCardsList = new ArrayList<>();

        // IRONCLAD

        stolenCardsList.add(new Cleave());
        stolenCardsList.add(new IronWave());
        stolenCardsList.add(new TwinStrike());
        stolenCardsList.add(new FlameBarrier());
        stolenCardsList.add(new Hemokinesis());
        stolenCardsList.add(new Barricade());

        // SILENT

        stolenCardsList.add(new DeadlyPoison());
        stolenCardsList.add(new SuckerPunch());
        stolenCardsList.add(new DodgeAndRoll());
        stolenCardsList.add(new Dash());
        stolenCardsList.add(new BouncingFlask());
        stolenCardsList.add(new DieDieDie());

        // DEFECT

        stolenCardsList.add(new Leap());
        stolenCardsList.add(new GoForTheEyes());
        stolenCardsList.add(new Melter());
        stolenCardsList.add(new RipAndTear());
        stolenCardsList.add(new Buffer());

        if (ModHelper.isModEnabled("bard")) {
            stolenCardsList.add(BardHelper.StudiedStrike());
            stolenCardsList.add(BardHelper.PhantasmalForce());
            stolenCardsList.add(BardHelper.Thunderwave());
            stolenCardsList.add(BardHelper.BestowCurse());
            stolenCardsList.add(BardHelper.LifeDrain());
            stolenCardsList.add(BardHelper.Shifting());
        }

        if (ModHelper.isModEnabled("thorton")) {
            stolenCardsList.add(ThortonHelper.StudiedStrike());
            stolenCardsList.add(ThortonHelper.PhantasmalForce());
            stolenCardsList.add(ThortonHelper.Thunderwave());
            stolenCardsList.add(ThortonHelper.BestowCurse());
            stolenCardsList.add(ThortonHelper.LifeDrain());
            stolenCardsList.add(ThortonHelper.Shifting());
        }

        if (upgraded) {
            for (AbstractCard c : stolenCardsList) {
                c.upgrade();
            }
        }

        AbstractCard c = stolenCardsList.get(AbstractDungeon.cardRandomRng.random(stolenCardsList.size() - 1));
        AbstractDungeon.actionManager.addToBottom(new AbstractGameAction() {
            @Override
            public void update() {
                if (this.amount + AbstractDungeon.player.hand.size() > 10) {// 63
                    AbstractDungeon.player.createHandIsFullDialog();// 64
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(c, (float) Settings.WIDTH / 2.0F + (25.0F * Settings.scale) + AbstractCard.IMG_WIDTH, (float) Settings.HEIGHT / 2.0F));// 160 162
                } else {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(c));// 92
                }


                if (this.amount > 0) {// 72
                    AbstractDungeon.actionManager.addToTop(new WaitAction(0.8F));// 73
                }

                this.isDone = true;// 76
            }
        });
        AlwaysRetainField.alwaysRetain.set(c, true);
        c.exhaust = true;
        c.freeToPlayOnce = true;
        c.rawDescription = "Retain. NL " + c.rawDescription + " NL Exhaust.";
        c.name = "Stolen " + c.name;
        c.initializeDescription();
        this.isDone = true;
    }
}
