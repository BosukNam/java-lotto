package com.game.lotto.ticket;

import com.game.lotto.count.ManualLottoTicketCount;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

import java.util.List;

public class ManualNumberLottoTickets extends LottoTickets {

    public ManualNumberLottoTickets(ManualLottoTicketCount manualLottoCount) {
        addManualTicketsByCount(manualLottoCount);
    }

    public void addManualTicketsByCount(ManualLottoTicketCount manualLottoCount) {
        List<List<Integer>> manualLottoNumbers = InputView.inputManualLottoNumber(manualLottoCount.getValue());
        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            LottoTicket lottoTicket = new LottoTicket(new ManualLottoNumberGenerator(manualLottoNumber));
            addTicket(lottoTicket);
        }
    }
}
