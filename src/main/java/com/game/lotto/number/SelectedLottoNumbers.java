package com.game.lotto.number;

import com.game.lotto.ui.InputView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SelectedLottoNumbers {
    public static final int LOTTO_NUMBER_SELECT_COUNT = 6;

    private final List<LottoNumber> selectedNumbers;

    public SelectedLottoNumbers() {
        this(InputView.inputNumbersWithSeparator());
    }

    public SelectedLottoNumbers(LottoNumbers lottoNumbers) {
        this.selectedNumbers = lottoNumbers.getLottoNumbers();
    }

    public SelectedLottoNumbers(List<Integer> selectedNumbers) {
        isValidSelectedCount(selectedNumbers);
        this.selectedNumbers = selectedNumbers.stream().map(LottoNumber::new).collect(Collectors.toUnmodifiableList());
    }

    private void isValidSelectedCount(List<? extends Object> numbers) {
        Optional<List<? extends Object>> nullableNumbers = Optional.ofNullable(numbers);
        if (nullableNumbers.isEmpty() || nullableNumbers.get().size() != LOTTO_NUMBER_SELECT_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SELECT_COUNT + "개가 입력되어야 합니다!");
        }
    }

    public List<LottoNumber> getSelectedNumbers() {
        return selectedNumbers;
    }

    @Override
    public String toString() {
        return selectedNumbers.toString();
    }
}
