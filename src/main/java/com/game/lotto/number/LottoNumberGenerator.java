package com.game.lotto.number;

import java.util.ArrayList;
import java.util.List;

public abstract class LottoNumberGenerator {
    private static List<Integer> TOTAL_NUMBERS_OF_LOTTO_TICKET;
    static {
        TOTAL_NUMBERS_OF_LOTTO_TICKET = new ArrayList<>();
        for (int index = 1; index <= 45; index++) {
            TOTAL_NUMBERS_OF_LOTTO_TICKET.add(index);
        }
    }

    public static List<Integer> getTotalNumbersOfLottoTicket() {
        return TOTAL_NUMBERS_OF_LOTTO_TICKET;
    }

    public abstract List<Integer> generateNumbers();
}
