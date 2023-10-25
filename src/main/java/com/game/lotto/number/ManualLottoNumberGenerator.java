package com.game.lotto.number;

import java.util.List;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {

    private final SelectedLottoNumbers selectedLottoNumbers;

    public ManualLottoNumberGenerator(List<Integer> inputNumbers) {
        this.selectedLottoNumbers = new SelectedLottoNumbers(inputNumbers);
    }

    @Override
    public SelectedLottoNumbers generateNumbers() {
        return this.selectedLottoNumbers;
    }
}
