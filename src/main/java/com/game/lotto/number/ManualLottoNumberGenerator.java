package com.game.lotto.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumberGenerator extends LottoNumberGenerator {
    private static final String TICKET_NUMBER_STRING_INPUT_SEPARATOR = ", ";

    private String numbers;

    public ManualLottoNumberGenerator(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return Arrays.stream(numbers.split(TICKET_NUMBER_STRING_INPUT_SEPARATOR))
                .mapToInt(value -> Integer.parseInt(value))
                .boxed()
                .collect(Collectors.toList());
    }
}
