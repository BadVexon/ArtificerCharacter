package theTinker.util;

import com.megacrit.cardcrawl.cards.AbstractCard;
import theThorton.cards.*;

public class ThortonHelper {
    public static AbstractCard StudiedStrike() {
        return new Distance();
    }

    public static AbstractCard PhantasmalForce() {
        return new DualBap();
    }

    public static AbstractCard Thunderwave() {
        return new LongTermPayoff();
    }

    public static AbstractCard BestowCurse() {
        return new BoardroomBlast();
    }

    public static AbstractCard LifeDrain() {
        return new LastDitchEffort();
    }

    public static AbstractCard Shifting() {
        return new Hexaghostify();
    }
}
