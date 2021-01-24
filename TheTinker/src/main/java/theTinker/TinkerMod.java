package theTinker;

import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.Loader;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rewards.RewardSave;
import javassist.CtClass;
import javassist.Modifier;
import javassist.NotFoundException;
import org.clapper.util.classutil.*;
import theTinker.characters.TheTinker;
import theTinker.patches.RewardItemTypeEnumPatch;
import theTinker.relics.AbstractTinkerRelic;
import theTinker.relics.Machines.AbstractMachine;
import theTinker.relics.Tools.AbstractTool;
import theTinker.rewards.*;
import theTinker.util.DraggableBox;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

@SpireInitializer
public class TinkerMod implements
        EditRelicsSubscriber,
        EditStringsSubscriber,
        EditCharactersSubscriber,
        PostUpdateSubscriber,
        StartGameSubscriber,
        PostInitializeSubscriber {
    public static final Color TINKER_YELLOW = new Color(1F, 0.949F, 0.121F, 1F);
    public static final String THE_TINKER_SHOULDER_1 = "tinkerResources/images/char/tinkerChar/shoulder.png";
    public static final String THE_TINKER_SHOULDER_2 = "tinkerResources/images/char/tinkerChar/shoulder2.png";
    public static final String THE_TINKER_CORPSE = "tinkerResources/images/char/tinkerChar/corpse.png";
    private static final String THE_TINKER_BUTTON = "tinkerResources/images/charSelect/TinkerCharacterButton.png";
    private static final String TINKER_PORTRAIT = "tinkerResources/images/charSelect/TinkerCharacterBG.png";
    private static String modID;
    private static boolean thindone;

    public static boolean loseRelic;
    public static String lossRelic;

    public static DraggableBox newHitbox;
    public static DraggableBox newHitbox2;
    public static DraggableBox newHitbox3;

    public TinkerMod() {
        BaseMod.subscribe(this);
        modID = "tinker";
        newHitbox = new DraggableBox();
        newHitbox2 = new DraggableBox();
        newHitbox3 = new DraggableBox();
    }

    public static String makeRelicPath(String resourcePath) {
        return modID + "Resources/images/relics/" + resourcePath;
    }

    public static String makeRelicOutlinePath(String resourcePath) {
        return modID + "Resources/images/relics/outline/" + resourcePath;
    }

    public void receivePostInitialize() {

        BaseMod.registerCustomReward(
                RewardItemTypeEnumPatch.BONUS_HEAL,
                (rewardSave) -> { //on load
                    return new HealRewardItem();
                }, (customReward) -> { //on save
                    return new RewardSave(customReward.type.toString(), null);
                });

        BaseMod.registerCustomReward(
                RewardItemTypeEnumPatch.BONUS_GOLD,
                (rewardSave) -> { //on load
                    return new BonusGoldRewardItem();
                }, (customReward) -> { //on save
                    return new RewardSave(customReward.type.toString(), null);
                });

        BaseMod.registerCustomReward(
                RewardItemTypeEnumPatch.MACHINE_BOOST,
                (rewardSave) -> { //on load
                    return new MachineBoostRewardItem();
                }, (customReward) -> { //on save
                    return new RewardSave(customReward.type.toString(), null);
                });

        BaseMod.registerCustomReward(
                RewardItemTypeEnumPatch.TOOL_RECHRAGE,
                (rewardSave) -> { //on load
                    return new ToolRechargeRewardItem();
                }, (customReward) -> { //on save
                    return new RewardSave(customReward.type.toString(), null);
                });

        BaseMod.registerCustomReward(
                RewardItemTypeEnumPatch.RANDOM_MACHINE_BOOST,
                (rewardSave) -> { //on load
                    return new RandomMachineBoostRewardItem();
                }, (customReward) -> { //on save
                    return new RewardSave(customReward.type.toString(), null);
                });

    }

    @SuppressWarnings("unused")
    public static void initialize() {
        TinkerMod tinkerMod = new TinkerMod();
    }

    public static String makeID(String idText) {
        return modID + ":" + idText;
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new TheTinker("the Tinker", TheTinker.Enums.THE_TINKER), THE_TINKER_BUTTON, TINKER_PORTRAIT, TheTinker.Enums.THE_TINKER);
    }

    @Override
    public void receiveEditRelics() {
        try {
            autoAddRelics();
        } catch (InstantiationException | URISyntaxException | IllegalAccessException | NotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(RelicStrings.class, modID + "Resources/localization/eng/TinkerMod-Relic-Strings.json");

        BaseMod.loadCustomStringsFile(CharacterStrings.class, modID + "Resources/localization/eng/TinkerMod-Character-Strings.json");
    }

    @Override
    public void receiveStartGame() {
        if (!thindone) {
            newHitbox.hb.resize(300 , 120 );
            newHitbox.hb.move(256 , 400 );
            newHitbox2.hb.resize(600 , 120 );
            newHitbox2.hb.move(512 , 600 );
            newHitbox3.hb.resize(450 , 120 );
            newHitbox3.hb.move(384 , 800 );
        }
        thindone = true;
    }

    private static void autoAddRelics()
            throws URISyntaxException, IllegalAccessException, InstantiationException, NotFoundException, ClassNotFoundException {
        ClassFinder finder = new ClassFinder();
        URL url = TinkerMod.class.getProtectionDomain().getCodeSource().getLocation();
        finder.add(new File(url.toURI()));

        ClassFilter filter =
                new AndClassFilter(
                        new NotClassFilter(new InterfaceOnlyClassFilter()),
                        new NotClassFilter(new AbstractClassFilter()),
                        new ClassModifiersClassFilter(Modifier.PUBLIC),
                        new RelicFilter()
                );
        Collection<ClassInfo> foundClasses = new ArrayList<>();
        finder.findClasses(foundClasses, filter);

        for (ClassInfo classInfo : foundClasses) {
            CtClass cls = Loader.getClassPool().get(classInfo.getClassName());
            if (cls.hasAnnotation(RelicIgnore.class)) {
                continue;
            }
            boolean isRelic = false;
            CtClass superCls = cls;
            while (superCls != null) {
                superCls = superCls.getSuperclass();
                if (superCls == null) {
                    break;
                }
                if ((superCls.getName().equals(AbstractTinkerRelic.class.getName()))) {
                    isRelic = true;
                    break;
                }
            }
            if (!isRelic) {
                continue;
            }
            System.out.println(classInfo.getClassName());
            AbstractTinkerRelic relic = (AbstractTinkerRelic) Loader.getClassPool().getClassLoader().loadClass(cls.getName()).newInstance();
            BaseMod.addRelic(relic, RelicType.SHARED);

        }
    }

    @Override
    public void receivePostUpdate() {
        if (loseRelic) {
            AbstractDungeon.player.loseRelic(lossRelic);
            loseRelic = false;
        }
    }

    public static boolean hasUpgradableRelics() {
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if ((r instanceof AbstractTool)) {
                if (!((AbstractTool) r).upgraded) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasUnchargedMachines() {
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r instanceof AbstractMachine) {
                if (r.counter < ((AbstractMachine) r).charges) {
                    return true;
                }
            }
        }
        return false;
    }
}