package theTinker.campfire;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.rooms.RestRoom;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import theTinker.TinkerMod;
import theTinker.relics.Drones.ScrapperDrone;
import theTinker.util.RelicSelectScreen;

import java.util.ArrayList;

public class CampfireScrapEffect extends AbstractGameEffect {
    private Color screenColor;
    private boolean relicSelected = true;
    private RelicSelectScreen relicSelectScreen;
    private boolean didThing = false;

    public CampfireScrapEffect() {
        this.screenColor = AbstractDungeon.fadeColor.cpy();// 32
        this.duration = 1.5F;// 38
        this.screenColor.a = 0.0F;// 39
        AbstractDungeon.overlayMenu.proceedButton.hide();// 40
    }// 41

    public void update() {
        if (!AbstractDungeon.isScreenUp) {// 45
            this.duration -= Gdx.graphics.getDeltaTime();// 46
            this.updateBlackScreenColor();// 47
        }

        if (!didThing) {
            relicSelected = false;
            ArrayList<AbstractRelic> relics = new ArrayList<>();
            for (AbstractRelic q : AbstractDungeon.player.relics) {
                AbstractRelic re = q.makeCopy();
                re.isSeen = true;
                relics.add(re);
            }

            relicSelectScreen = new RelicSelectScreen();
            relicSelectScreen.open(relics);
            didThing = true;
        }

        if (!relicSelected) {
            if (relicSelectScreen.doneSelecting()) {
                relicSelected = true;

                AbstractRelic relic = relicSelectScreen.getSelectedRelics().get(0).makeCopy();
                TinkerMod.loseRelic = true;
                TinkerMod.lossRelic = relic.relicId;
                AbstractDungeon.player.gainGold(100);
                if (AbstractDungeon.player.hasRelic(ScrapperDrone.ID)) {
                    AbstractDungeon.player.getRelic(ScrapperDrone.ID).flash();
                    AbstractDungeon.player.gainGold(100);
                }

                AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;
            } else {
                relicSelectScreen.update();
            }
        }

        if (this.duration < 0.0F) {// 84
            this.isDone = true;// 85
            if (CampfireUI.hidden) {// 86
                AbstractRoom.waitTimer = 0.0F;// 87
                AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;// 88
                ((RestRoom) AbstractDungeon.getCurrRoom()).cutFireSound();// 89
            }
        }

    }// 92

    private void updateBlackScreenColor() {
        if (this.duration > 1.0F) {// 98
            this.screenColor.a = Interpolation.fade.apply(1.0F, 0.0F, (this.duration - 1.0F) * 2.0F);// 99
        } else {
            this.screenColor.a = Interpolation.fade.apply(0.0F, 1.0F, this.duration / 1.5F);// 101
        }

    }// 103

    public void render(SpriteBatch sb) {
        sb.setColor(this.screenColor);// 107
        sb.draw(ImageMaster.WHITE_SQUARE_IMG, 0.0F, 0.0F, (float) Settings.WIDTH, (float) Settings.HEIGHT);// 108
        if (!relicSelected) {
            relicSelectScreen.render(sb);
        }
    }// 113

    public void dispose() {
    }// 118
}
