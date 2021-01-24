package theTinker.relics.Machines;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theTinker.TinkerMod;
import theTinker.relics.AbstractTinkerRelic;
import theTinker.relics.Drones.AbstractDrone;
import theTinker.relics.Tools.AbstractTool;

import java.util.ArrayList;

public class LastResortinator extends AbstractMachine {
    public static String ID = TinkerMod.makeID(LastResortinator.class.getSimpleName());

    public LastResortinator() {
        super(ID, "LastResortinator.png", "LastResortinator.png", RelicTier.SHOP, LandingSound.FLAT, 6);
    }

    @Override
    public void activate(AbstractPlayer p) {
        AbstractRelic r = RelicLibrary.getRelic(getTinkerRelics().get(AbstractDungeon.cardRandomRng.random(getTinkerRelics().size() - 1))).makeCopy();
        if (r instanceof AbstractTool) {
            ((AbstractTool) r).activate(p);
        }
        if (r instanceof AbstractMachine) {
            ((AbstractMachine) r).activate(p);
        }
        if (r instanceof AbstractDrone) {
            ((AbstractDrone) r).passive(p);
        }
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
