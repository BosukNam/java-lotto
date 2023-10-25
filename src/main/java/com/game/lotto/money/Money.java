package com.game.lotto.money;


import com.game.lotto.count.Number;
import com.game.lotto.ui.InputView;

public class Money extends Number implements Comparable {

    public Money() {
        this(InputView.inputPrice());
    }

    public Money(Number number) {
        super(number.getValue());
    }

    private Money(int amount) {
        super(amount);
    }

    public void deposit(int amount) {
        isValidAmount(amount);
        this.value += amount;
    }

    public void withdrawAmount(int amount) {
        isValidAmount(amount);
        this.value -= amount;
    }

    private static void isValidAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("음수값은 입금할 수 없습니다!");
        }
    }

    @Override
    public int compareTo(Object o) {
        Money compareMoney = (Money)o;
        return value - compareMoney.getValue();
    }
}
