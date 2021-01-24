package theTinker.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.rewards.RewardItem;

public class RewardItemTypeEnumPatch {
	@SpireEnum
	public static RewardItem.RewardType RANDOM_MACHINE_BOOST;
	@SpireEnum
	public static RewardItem.RewardType MACHINE_BOOST;
	@SpireEnum
	public static RewardItem.RewardType TOOL_RECHRAGE;
	@SpireEnum
	public static RewardItem.RewardType BONUS_HEAL;
	@SpireEnum
	public static RewardItem.RewardType BONUS_GOLD;

}