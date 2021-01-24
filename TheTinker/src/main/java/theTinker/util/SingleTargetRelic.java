package theTinker.util;

import com.megacrit.cardcrawl.monsters.AbstractMonster;

public interface SingleTargetRelic {
    void onTargetChosen(AbstractMonster c);
}