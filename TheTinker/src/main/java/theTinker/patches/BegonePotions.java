package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.EventRoom;
import com.megacrit.cardcrawl.rooms.MonsterRoom;
import com.megacrit.cardcrawl.rooms.MonsterRoomElite;
import theTinker.characters.TheTinker;
import theTinker.rewards.*;

import java.util.ArrayList;

import static com.megacrit.cardcrawl.rooms.AbstractRoom.blizzardPotionMod;

@SpirePatch(
        clz = AbstractRoom.class,
        method = "addPotionToRewards",
        paramtypez = {

        }
)

public class BegonePotions {
    public static SpireReturn Prefix(AbstractRoom __instance) {
        if (AbstractDungeon.player instanceof TheTinker) {
            int chance = 0;// 752
            if (__instance instanceof MonsterRoomElite) {// 753
                chance = 40;// 754
                chance = chance + blizzardPotionMod;// 755
            } else if (__instance instanceof MonsterRoom) {// 756
                if (!AbstractDungeon.getMonsters().haveMonstersEscaped()) {// 757
                    chance = 40;// 758
                    chance = chance + blizzardPotionMod;// 759
                }
            } else if (__instance instanceof EventRoom) {// 761
                chance = 40;// 762
                chance = chance + blizzardPotionMod;// 763
            }

            if (AbstractDungeon.potionRng.random(0, 99) >= chance && !Settings.isDebug) {// 779
                blizzardPotionMod += 10;// 784
                return SpireReturn.Return(null);
            } else {
                RewardItem r = getRandomTinkerReward();
                __instance.rewards.add(r);
                blizzardPotionMod -= 10;// 782
                return SpireReturn.Return(null);
            }
        }
        return SpireReturn.Continue();
    }

    private static RewardItem getRandomTinkerReward() {
        ArrayList<RewardItem> rewardItems = new ArrayList<>();
        rewardItems.add(new BonusGoldRewardItem());
        rewardItems.add(new HealRewardItem());
        rewardItems.add(new MachineBoostRewardItem());
        rewardItems.add(new RandomMachineBoostRewardItem());
        rewardItems.add(new ToolRechargeRewardItem());
        return rewardItems.get(AbstractDungeon.cardRandomRng.random(rewardItems.size() - 1));
    }
}