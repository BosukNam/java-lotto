package com.game.lotto.count;

import com.game.lotto.ui.InputView;

public class ManualLottoTicketCount extends Number {
    public ManualLottoTicketCount() {
        super(InputView.inputManualLottoCount());
    }
}
