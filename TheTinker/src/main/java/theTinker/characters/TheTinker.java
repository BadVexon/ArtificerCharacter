package theTinker.characters;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.blights.AbstractBlight;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.curses.Injury;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import theTinker.TinkerMod;
import theTinker.relics.Drones.AbstractDrone;
import theTinker.relics.Drones.FirstDrone;
import theTinker.relics.Machines.Bombinator;
import theTinker.relics.Tools.*;

import java.util.ArrayList;

import static theTinker.TinkerMod.*;

public class TheTinker extends CustomPlayer {
    private static final String[] orbTextures = {
            "tinkerResources/images/char/tinkerChar/orb/layer1.png",
            "tinkerResources/images/char/tinkerChar/orb/layer2.png",
            "tinkerResources/images/char/tinkerChar/orb/layer3.png",
            "tinkerResources/images/char/tinkerChar/orb/layer4.png",
            "tinkerResources/images/char/tinkerChar/orb/layer5.png",
            "tinkerResources/images/char/tinkerChar/orb/layer6.png",
            "tinkerResources/images/char/tinkerChar/orb/layer1d.png",
            "tinkerResources/images/char/tinkerChar/orb/layer2d.png",
            "tinkerResources/images/char/tinkerChar/orb/layer3d.png",
            "tinkerResources/images/char/tinkerChar/orb/layer4d.png",
            "tinkerResources/images/char/tinkerChar/orb/layer5d.png",};
    private static final String ID = makeID("theTinker");
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
    private static final String[] NAMES = characterStrings.NAMES;
    private static final String[] TEXT = characterStrings.TEXT;

    public int droneSlots = 3;
    public int machineSlots = 5;
    public int toolSlots = 7;

    public TheTinker(String name, PlayerClass setClass) {
        super(name, setClass, orbTextures,
                "tinkerResources/images/char/tinkerChar/orb/vfx.png", null,
                new SpriterAnimation(
                        "tinkerResources/images/char/tinkerChar/tinker.scml"));


        initializeClass(null,
                THE_TINKER_SHOULDER_1,
                THE_TINKER_SHOULDER_2,
                THE_TINKER_CORPSE,
                getLoadout(), 20.0F, -10.0F, 224.0F, 324.0F, new EnergyManager(0));


        dialogX = (drawX + 0.0F * Settings.scale);
        dialogY = (drawY + 300.0F * Settings.scale);
        this.potionSlots = 0;
    }

    public void applyStartOfTurnRelics() {
        for (AbstractRelic r : this.relics) {
            if (r instanceof AbstractTool) {
                r.atTurnStart();
            }
        }

        for (AbstractRelic r : this.relics) {
            if (r instanceof AbstractDrone) {
                r.atTurnStart();
            }
        }

        for (AbstractRelic r : this.relics) {
            if (!(r instanceof AbstractTool) && !(r instanceof AbstractDrone)) {
                r.atTurnStart();
            }
        }


        for (AbstractBlight b : this.blights) {
            if (b != null) {// 2412
                b.atTurnStart();// 2413
            }
        }
    }

    public void applyStartOfTurnPostDrawRelics() {
        for (AbstractRelic r : this.relics) {
            if (r instanceof AbstractTool) {
                r.atTurnStartPostDraw();
            }
        }

        for (AbstractRelic r : this.relics) {
            if (r instanceof AbstractDrone) {
                r.atTurnStartPostDraw();
            }
        }

        for (AbstractRelic r : this.relics) {
            if (!(r instanceof AbstractTool) && !(r instanceof AbstractDrone)) {
                r.atTurnStartPostDraw();
            }
        }
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(NAMES[0], TEXT[0],
                75, 75, 0, 255, 0, this, getStartingRelics(),
                getStartingDeck(), false);
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(Injury.ID);
        retVal.add(Injury.ID);
        retVal.add(Injury.ID);
        retVal.add(Injury.ID);
        retVal.add(Injury.ID);
        return retVal;
    }

    public ArrayList<String> getStartingRelics() {
        ArrayList<String> startingRelics = new ArrayList<>();

        startingRelics.add(FirstDrone.ID);
        startingRelics.add(Bombinator.ID);
        startingRelics.add(MultiTool.ID);
        startingRelics.add(SwordLauncher.ID);
        startingRelics.add(SnapGuard.ID);
        startingRelics.add(SuppressionSpray.ID);

        return startingRelics;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.play("AUTOMATON_ORB_SPAWN");
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT,
                false);
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "AUTOMATON_ORB_SPAWN";
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 7;
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return AbstractCard.CardColor.RED;
    }

    @Override
    public Color getCardTrailColor() {
        return TinkerMod.TINKER_YELLOW;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    @Override
    public String getLocalizedCharacterName() {
        return NAMES[0];
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return null;
    }

    @Override
    public String getTitle(AbstractPlayer.PlayerClass playerClass) {
        return NAMES[1];
    }

    @Override
    public AbstractPlayer newInstance() {
        return new TheTinker(name, chosenClass);
    }

    @Override
    public Color getCardRenderColor() {
        return TinkerMod.TINKER_YELLOW;
    }

    @Override
    public Color getSlashAttackColor() {
        return TinkerMod.TINKER_YELLOW;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{
                AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY};
    }

    @Override
    public String getSpireHeartText() {
        return TEXT[1];
    }

    @Override
    public String getVampireText() {
        return TEXT[2];
    }

    public static class Enums {
        @SpireEnum
        public static AbstractPlayer.PlayerClass THE_TINKER;
    }
}
