package com.game.lotto.ui;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_LAST_WINNER_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String TICKET_NUMBER_STRING_INPUT_SEPARATOR = ",";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static Integer inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return inputNumber();
    }

    public static Integer inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        return inputNumber();
    }

    public static List<List<Integer>> inputManualLottoNumber(int count) {
        if(count < 0) {
            throw new IllegalArgumentException("음수값은 입력할 수 없습니다!");
        }

        List<List<Integer>> result = new ArrayList<>();
        if(count == 0) {
            return result;
        }

        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);
        for(int i=0; i<count; i++) {
            result.add(inputNumbersWithSeparator());
        }
        return result;
    }


    public static List<Integer> inputLastWinnerNumber() {
        System.out.println(INPUT_LAST_WINNER_NUMBER_MESSAGE);
        return inputNumbersWithSeparator();
    }

    public static Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return inputNumber();
    }

    public static Integer inputNumber() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다! 숫자와 콤마만 입력해주세요!");
        }
    }

    public static List<Integer> inputNumbersWithSeparator() {
        String inputString = inputString();
        return numbersFromString(inputString);
    }

    private static List<Integer> numbersFromString(String inputString) {
        try {
            return Arrays.stream(inputString.split(TICKET_NUMBER_STRING_INPUT_SEPARATOR))
                    .map(x -> Integer.parseInt(x.trim()))
                    .collect(Collectors.toUnmodifiableList());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자가 아닙니다! 숫자만 입력해주세요!");
        }
    }

    public static String inputString() {
        return new Scanner(System.in).nextLine();
    }
}
