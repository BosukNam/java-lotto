package com.game.lotto.number;


import java.util.List;
import java.util.Optional;

import static com.game.lotto.number.SelectedLottoNumbers.LOTTO_NUMBER_SELECT_COUNT;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        isValidSelectedCount(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void isValidSelectedCount(List<LottoNumber> numbers) {
        Optional<List<LottoNumber>> nullableNumbers = Optional.ofNullable(numbers);
        if (nullableNumbers.isEmpty() || nullableNumbers.get().size() != LOTTO_NUMBER_SELECT_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SELECT_COUNT + "개가 입력되어야 합니다!");
        }
    }
}
