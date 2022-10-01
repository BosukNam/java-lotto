package com.game.lotto.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator extends LottoNumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> totalNumbers = LottoNumberGenerator.getTotalNumbersOfLottoTicket();
        Collections.shuffle(totalNumbers);
        ArrayList<Integer> subNumbers = new ArrayList<>();
        subNumbers.addAll(totalNumbers.subList(0, 6));
        Collections.sort(subNumbers);
        return subNumbers;
    }
}
