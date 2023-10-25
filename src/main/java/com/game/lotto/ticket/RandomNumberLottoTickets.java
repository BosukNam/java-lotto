package com.game.lotto.ticket;

import com.game.lotto.count.Number;
import com.game.lotto.money.Money;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.ui.ResultView;

public class RandomNumberLottoTickets extends LottoTickets {

    public RandomNumberLottoTickets(Money purchaseMoney) {
        int randomTicketCount = purchaseMoney.getValue() / LottoTicket.PRICE_OF_TICKET_UNIT;
        addRandomTicketsByCount(new Number(randomTicketCount));
    }

    public void addRandomTicketsByCount(Number ticketCount) {
        for (int index = 0; index < ticketCount.getValue(); index++) {
            LottoTicket lottoTicket = new LottoTicket(new RandomLottoNumberGenerator());
            addTicket(lottoTicket);
        }
    }
}
