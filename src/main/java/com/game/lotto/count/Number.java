package com.game.lotto.count;

import com.game.lotto.ui.InputView;

public class Number {
    protected int value;

    public Number() {
        this(InputView.inputNumber());
    }

    public Number(int count) {
        if(count < 0) {
            throw new IllegalArgumentException("음수값은 입력할 수 없습니다!");
        }
        this.value = count;
    }

    public int getValue() {
        return value;
    }
}
