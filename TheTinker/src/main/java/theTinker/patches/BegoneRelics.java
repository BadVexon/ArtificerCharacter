package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.characters.TheTinker;
import theTinker.relics.AbstractTinkerRelic;

import java.util.ArrayList;

@SpirePatch(
        clz = AbstractDungeon.class,
        method = "initializeRelicList"
)
public class BegoneRelics {
    public static void Prefix(AbstractDungeon __instance) {
        if (AbstractDungeon.player.chosenClass == TheTinker.Enums.THE_TINKER) {
            AbstractDungeon.relicsToRemoveOnStart.addAll(getNonTinkerRelics());
        } else {
            AbstractDungeon.relicsToRemoveOnStart.addAll(getTinkerRelics());
        }
    }

    private static ArrayList<String> getNonTinkerRelics() {
        ArrayList<String> nonTinkerRelics = new ArrayList<>();
        for (AbstractRelic r : RelicLibrary.commonList) {
            if (!(r instanceof AbstractTinkerRelic)) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        for (AbstractRelic r : RelicLibrary.uncommonList) {
            if (!(r instanceof AbstractTinkerRelic)) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        for (AbstractRelic r : RelicLibrary.rareList) {
            if (!(r instanceof AbstractTinkerRelic)) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        for (AbstractRelic r : RelicLibrary.shopList) {
            if (!(r instanceof AbstractTinkerRelic)) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        for (AbstractRelic r : RelicLibrary.bossList) {
            if (!(r instanceof AbstractTinkerRelic)) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        return nonTinkerRelics;
    }


    private static ArrayList<String> getTinkerRelics() {
        ArrayList<String> nonTinkerRelics = new ArrayList<>();
        for (AbstractRelic r : RelicLibrary.commonList) {
            if (r instanceof AbstractTinkerRelic) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        for (AbstractRelic r : RelicLibrary.uncommonList) {
            if (r instanceof AbstractTinkerRelic) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        for (AbstractRelic r : RelicLibrary.rareList) {
            if (r instanceof AbstractTinkerRelic) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        for (AbstractRelic r : RelicLibrary.shopList) {
            if (r instanceof AbstractTinkerRelic) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        for (AbstractRelic r : RelicLibrary.bossList) {
            if (r instanceof AbstractTinkerRelic) {
                nonTinkerRelics.add(r.relicId);
            }
        }
        return nonTinkerRelics;
    }
}