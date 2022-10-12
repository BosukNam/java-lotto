package com.game.lotto.count;


public class Strike {

    private int count;

    public Strike() {
        this(0);
    }

    public Strike(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void addCount(int count) {
        this.count += count;
    }

}
