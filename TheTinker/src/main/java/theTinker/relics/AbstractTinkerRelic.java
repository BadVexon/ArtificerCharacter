package theTinker.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import theTinker.TinkerMod;
import theTinker.characters.TheTinker;
import theTinker.relics.Drones.AbstractDrone;
import theTinker.relics.Machines.AbstractMachine;
import theTinker.relics.Tools.AbstractTool;
import theTinker.util.RelicSelectScreen;
import theTinker.util.TextureLoader;

import java.util.ArrayList;

public abstract class AbstractTinkerRelic extends CustomRelic {

    private boolean relicSelected = true;
    private RelicSelectScreen relicSelectScreen;
    private boolean fakeHover = false;

    public AbstractTinkerRelic(String id, String texture, String outline, RelicTier tier, LandingSound sound) {
        super(id, TextureLoader.getTexture(TinkerMod.makeRelicPath(texture)), TextureLoader.getTexture(TinkerMod.makeRelicOutlinePath(outline)), tier, sound);
        if (this instanceof AbstractDrone) {
            this.tips.add(new PowerTip("Drone", "Drones have an effect at the start of your turn. They can also harbor other passive effects. You can only carry #b3 Drones at a time."));
        } else if (this instanceof AbstractMachine) {
            this.tips.add(new PowerTip("Machine", "Machines are right clicked to activate. They have a certain amount of charges. You can only carry #b5 Machines at a time."));
        }
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    protected void initializeTips() {
        super.initializeTips();
        if (tips.size() > 0 && tips.get(0).header.toLowerCase().contains(name.toLowerCase())) {
            tips.get(0).header = TinkerMod.makeID("@RECOLOR@") + getColorChar() + tips.get(0).header;
        }
    }

    public void updatePosition() {
        if (AbstractDungeon.player instanceof TheTinker) {
            if (this instanceof AbstractDrone) {
                if (AbstractDungeon.player.relics.contains(this)) {
                    int i = 0;
                    for (AbstractRelic r : AbstractDungeon.player.relics) {
                        if (r == this) {
                            break;
                        }
                        if (r instanceof AbstractDrone) {
                            i++;
                        }
                    }
                    this.currentX = (TinkerMod.newHitbox.hb.x + ((60F * i) + 40));
                    this.currentY = TinkerMod.newHitbox.hb.cY - 10;
                    this.targetX = this.currentX;
                    this.targetY = this.currentY;
                    this.hb.move(this.currentX, this.currentY);
                }
            } else if (this instanceof AbstractMachine) {
                if (AbstractDungeon.player.relics.contains(this)) {
                    int i = 0;
                    for (AbstractRelic r : AbstractDungeon.player.relics) {
                        if (r == this) {
                            break;
                        }
                        if (r instanceof AbstractMachine) {
                            i++;
                        }
                    }
                    this.currentX = (TinkerMod.newHitbox3.hb.x + ((60F * i) + 45));
                    this.currentY = TinkerMod.newHitbox3.hb.cY - 10;
                    this.targetX = this.currentX;
                    this.targetY = this.currentY;
                    this.hb.move(this.currentX, this.currentY);
                }
            } else if (this instanceof AbstractTool) {
                if (AbstractDungeon.player.relics.contains(this)) {
                    int i = 0;
                    for (AbstractRelic r : AbstractDungeon.player.relics) {
                        if (r == this) {
                            break;
                        }
                        if (r instanceof AbstractTool) {
                            i++;
                        }
                    }
                    this.currentX = (TinkerMod.newHitbox2.hb.x + ((60F * i) + 45));
                    this.currentY = TinkerMod.newHitbox2.hb.cY - 10;
                    this.targetX = this.currentX;
                    this.targetY = this.currentY;
                    this.hb.move(this.currentX, this.currentY);
                }
            }
        }
    }

    public void onEquip() {
        if (AbstractDungeon.player instanceof TheTinker) {
            if (this instanceof AbstractDrone) {
                int i = 0;
                for (AbstractRelic r : AbstractDungeon.player.relics) {
                    if (r instanceof AbstractDrone) {
                        i++;
                    }
                }
                if (i > ((TheTinker) AbstractDungeon.player).droneSlots) {
                    if (AbstractDungeon.isScreenUp) {
                        AbstractDungeon.dynamicBanner.hide();
                        AbstractDungeon.overlayMenu.cancelButton.hide();
                        AbstractDungeon.previousScreen = AbstractDungeon.screen;
                    }
                    AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.INCOMPLETE;

                    openRelicSelect();
                }
            } else if (this instanceof AbstractMachine) {
                int i = 0;
                for (AbstractRelic r : AbstractDungeon.player.relics) {
                    if (r instanceof AbstractMachine) {
                        i++;
                    }
                }
                if (i > ((TheTinker) AbstractDungeon.player).machineSlots) {
                    if (AbstractDungeon.isScreenUp) {
                        AbstractDungeon.dynamicBanner.hide();
                        AbstractDungeon.overlayMenu.cancelButton.hide();
                        AbstractDungeon.previousScreen = AbstractDungeon.screen;
                    }
                    AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.INCOMPLETE;

                    openRelicSelect();
                }
            } else if (this instanceof AbstractTool) {
                int i = 0;
                for (AbstractRelic r : AbstractDungeon.player.relics) {
                    if (r instanceof AbstractTool) {
                        i++;
                    }
                }
                if (i > ((TheTinker) AbstractDungeon.player).toolSlots) {
                    if (AbstractDungeon.isScreenUp) {
                        AbstractDungeon.dynamicBanner.hide();
                        AbstractDungeon.overlayMenu.cancelButton.hide();
                        AbstractDungeon.previousScreen = AbstractDungeon.screen;
                    }
                    AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.INCOMPLETE;

                    openRelicSelect();
                }
            }
        }
    }

    @Override
    public void update() {
        updatePosition();
        super.update();
        if (!relicSelected) {
            if (relicSelectScreen.doneSelecting()) {
                relicSelected = true;

                AbstractRelic relic = relicSelectScreen.getSelectedRelics().get(0).makeCopy();
                TinkerMod.loseRelic = true;
                TinkerMod.lossRelic = relic.relicId;

                AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.COMPLETE;
            } else {
                relicSelectScreen.update();
                if (!hb.hovered) {
                    fakeHover = true;
                }
                hb.hovered = true;
            }
        }
    }

    @Override
    public void renderTip(SpriteBatch sb) {
        if (!relicSelected && fakeHover) {
            relicSelectScreen.render(sb);
        }
        if (fakeHover) {
            fakeHover = false;
            hb.hovered = false;
        } else {
            super.renderTip(sb);
        }
    }


    @Override
    public void renderInTopPanel(SpriteBatch sb) {
        super.renderInTopPanel(sb);
        if (!relicSelected && !fakeHover) {
            relicSelectScreen.render(sb);
        }
    }

    private void openRelicSelect() {
        relicSelected = false;

        ArrayList<AbstractRelic> relics = new ArrayList<>();
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r instanceof AbstractDrone && this instanceof AbstractDrone) {
                AbstractRelic re = r.makeCopy();
                re.counter = r.counter;
                re.isSeen = true;
                relics.add(re);
            } else if (r instanceof AbstractTool && this instanceof AbstractTool) {
                AbstractRelic re = r.makeCopy();
                re.counter = r.counter;
                re.isSeen = true;
                relics.add(re);
            } else if (r instanceof AbstractMachine && this instanceof AbstractMachine) {
                AbstractRelic re = r.makeCopy();
                re.counter = r.counter;
                re.isSeen = true;
                relics.add(re);
            }
        }
        relicSelectScreen = new RelicSelectScreen();
        relicSelectScreen.open(relics);
    }

    private char getColorChar() {
        if (this instanceof AbstractTool) {
            if (((AbstractTool) this).upgraded) {
                return 'g';
            }
            return 'b';
        } else if (this instanceof AbstractMachine) {
            return 'o';
        } else if (this instanceof AbstractDrone) {
            return 'p';
        }
        return 'x';
    }

    protected static DamageInfo makeInfo(int amount) {
        return new DamageInfo(AbstractDungeon.player, amount, DamageInfo.DamageType.THORNS);
    }

    protected static AbstractMonster frontMonster() {
        for (AbstractMonster m : AbstractDungeon.getCurrRoom().monsters.monsters) {
            if (!m.isDying && !m.isDead && !m.halfDead) {
                return m;
            }
        }
        System.out.println("WHAT THE FUCK???");
        return null;
    }


    protected static AbstractMonster backMonster() {
        AbstractMonster bleh = null;
        for (AbstractMonster m : AbstractDungeon.getCurrRoom().monsters.monsters) {
            if (!m.isDying && !m.isDead && !m.halfDead) {
                bleh = m;
            }
        }
        if (bleh != null) {
            return bleh;
        }
        System.out.println("WHAT THE FUCK???");
        return null;
    }

    protected void atb(AbstractGameAction action) {
        AbstractDungeon.actionManager.addToBottom(action);
    }

    protected static AbstractRelic getRandomHotTool() {
        ArrayList<AbstractRelic> blah = new ArrayList<>();
        for (AbstractRelic q : AbstractDungeon.player.relics) {
            if (q instanceof AbstractTool) {
                if (q.counter > 0) {
                    blah.add(q);
                }
            }
        }
        if (!blah.isEmpty()) {
            return blah.get(AbstractDungeon.cardRandomRng.random(blah.size() - 1));
        }
        return null;
    }

    protected static AbstractRelic getHottestTool() {
        AbstractRelic blah = null;
        int base = 0;
        for (AbstractRelic q : AbstractDungeon.player.relics) {
            if (q instanceof AbstractTool) {
                if (q.counter > base) {
                    blah = q;
                    base = q.counter;
                }
            }
        }
        return blah;
    }

    protected static AbstractRelic getCoolestTool() {
        AbstractRelic blah = null;
        int base = 999;
        for (AbstractRelic q : AbstractDungeon.player.relics) {
            if (q instanceof AbstractTool) {
                if (q.counter < base && q.counter > 0) {
                    blah = q;
                    base = q.counter;
                }
            }
        }
        return blah;
    }

    protected static AbstractRelic getRandomTool() {
        ArrayList<AbstractRelic> blah = new ArrayList<>();
        for (AbstractRelic q : AbstractDungeon.player.relics) {
            if (q instanceof AbstractTool) {
                blah.add(q);
            }
        }
        if (!blah.isEmpty()) {
            return blah.get(AbstractDungeon.cardRandomRng.random(blah.size() - 1));
        }
        return null;
    }

    public static AbstractRelic getRandomMachine() {
        ArrayList<AbstractRelic> blah = new ArrayList<>();
        for (AbstractRelic q : AbstractDungeon.player.relics) {
            if (q instanceof AbstractMachine) {
                blah.add(q);
            }
        }
        if (!blah.isEmpty()) {
            return blah.get(AbstractDungeon.cardRandomRng.random(blah.size() - 1));
        }
        return null;
    }

    protected static AbstractRelic getRandomDrone() {
        ArrayList<AbstractRelic> blah = new ArrayList<>();
        for (AbstractRelic q : AbstractDungeon.player.relics) {
            if (q instanceof AbstractDrone) {
                blah.add(q);
            }
        }
        if (!blah.isEmpty()) {
            return blah.get(AbstractDungeon.cardRandomRng.random(blah.size() - 1));
        }
        return null;
    }

    protected static AbstractPlayer adp() {
        return AbstractDungeon.player;
    }

    protected static ArrayList<AbstractMonster> monsterlist() {
        return AbstractDungeon.getCurrRoom().monsters.monsters;
    }
}
