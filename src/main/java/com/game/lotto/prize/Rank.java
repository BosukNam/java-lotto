package com.game.lotto.prize;

import com.game.lotto.money.Money;
import com.game.lotto.count.Strike;

public enum Rank {
    FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES(6, 2_000_000_000),
    SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES_AND_BONUS(5, 30_000_000),
    THIRD_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES(5, 1_500_000),
    FOURTH_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES(4, 50_000),
    FIFTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES(3, 5_000),
    NONE(0, 0);

    private final Strike strikes;
    private final Money moneyAmount;

    Rank(int strikes, int moneyAmount) {
        this.strikes = new Strike(strikes);
        this.moneyAmount = new Money(moneyAmount);
    }

    public Strike getStrikes() {
        return strikes;
    }

    public Money getMoneyAmount() {
        return moneyAmount;
    }

    public static Rank valueOf(Strike strikes) {
        if(strikes.getCount() == 6) return FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES;
        if(strikes.getCount() == 5) return THIRD_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES;
        if(strikes.getCount() == 4) return FOURTH_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES;
        if(strikes.getCount() == 3) return FIFTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES;
        return NONE;
    }
}
