package com.game.lotto.number;

import java.util.List;
import java.util.Optional;

public class SelectedLottoNumbers {
    public static final int LOTTO_NUMBER_SELECT_COUNT = 6;

    private final List<LottoNumber> selectedNumbers;

    public SelectedLottoNumbers(List<LottoNumber> selectedNumbers) {
        isValidNumbers(Optional.ofNullable(selectedNumbers));
        this.selectedNumbers = selectedNumbers;
    }

    private void isValidNumbers(Optional<List<LottoNumber>> numbers) {
        if (numbers.isEmpty() || numbers.get().size() != LOTTO_NUMBER_SELECT_COUNT) {
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
