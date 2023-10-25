package com.game.lotto.ticket;

import com.game.lotto.count.ManualLottoTicketCount;
import com.game.lotto.count.Number;
import com.game.lotto.money.Money;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.number.SelectedLottoNumbers;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public void addTicket(LottoTicket lottoTicket) {
        this.lottoTickets.add(lottoTicket);
    }

    public void addTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets.addAll(lottoTickets);
    }

    public List<LottoTicket> getTickets() {
        return lottoTickets.stream().collect(Collectors.toUnmodifiableList());
    }
}
