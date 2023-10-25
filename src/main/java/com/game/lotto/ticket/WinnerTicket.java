package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.number.SelectedLottoNumbers;

public class WinnerTicket {

    private final SelectedLottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    public WinnerTicket(SelectedLottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public SelectedLottoNumbers getNumbers() {
        return winnerNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
