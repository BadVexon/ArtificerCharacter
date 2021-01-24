package theTinker.relics.Tools;

import basemod.abstracts.CustomSavable;
import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import theTinker.actions.ToolActivateAction;
import theTinker.relics.AbstractTinkerRelic;

import java.lang.reflect.Type;

public abstract class AbstractTool extends AbstractTinkerRelic implements ClickableRelic, CustomSavable<Boolean> {
    public int cooldown;
    public int baseCooldown;
    public int magic;
    public boolean upgraded;
    public String realName;

    public AbstractTool(String id, String texture, String outline, RelicTier tier, LandingSound sound, int baseCool, int magicNum) {
        super(id, id.replace("tinker:", "") + ".png", "ToolTemplate.png", tier, sound);
        cooldown = baseCool;
        baseCooldown = baseCool;
        this.counter = 0;
        this.realName = this.name;
        magic = magicNum;
        this.description = getUpdatedDescription();
        this.tips.clear();// 138
        this.tips.add(new PowerTip(this.realName, this.description));// 139
        this.tips.add(new PowerTip("Tool", "Tools are right clicked to activate. They have a cooldown. You can only carry #b7 Tools at a time."));
        this.initializeTips();// 140
    }

    public AbstractTool(String id, String texture, String outline, RelicTier tier, LandingSound sound, int baseCool) {
        this(id, texture, outline, tier, sound, baseCool, 0);
    }

    public void upgrade() {
        callUpgrade();
        upgraded = true;
        realName += "+";
        this.cooldown = baseCooldown;
        this.description = getUpdatedDescription();
        this.tips.clear();// 138
        this.tips.add(new PowerTip(this.realName, this.description));// 139
        this.tips.add(new PowerTip("Tool", "Tools are right clicked to activate. They have a cooldown. You can only carry #b7 Tools."));
        this.initializeTips();// 140
    }

    public abstract void callUpgrade();

    public void onRightClick() {
        if (this.counter == 0 && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT && !AbstractDungeon.isScreenUp && !AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
            this.stopPulse();
            this.counter = cooldown;
            atb(new ToolActivateAction(this));
        }
    }

    public void atTurnStart() {
        if (this.counter > 0) {
            this.counter--;
        }
        if (this.counter == 0) {
            this.beginLongPulse();
        }
    }

    public Boolean onSave() {
        return this.upgraded;
    }

    public void onLoad(Boolean upg) {
        if (upg) {
            this.upgrade();
        }
    }

    @Override
    public Type savedType() {
        return Boolean.TYPE;
    }

    public void onVictory() {
        this.cooldown = this.baseCooldown;
    }

    public abstract void activate(AbstractPlayer p);
}
