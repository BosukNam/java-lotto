package com.game.lotto.money;


import com.game.lotto.count.ManualLottoTicketCount;
import com.game.lotto.count.Number;
import com.game.lotto.ticket.LottoTicket;

public class TicketMoney extends Money {

    public TicketMoney(ManualLottoTicketCount manualLottoTicketCount) {
        super(new Number(manualLottoTicketCount.getValue() * LottoTicket.PRICE_OF_TICKET_UNIT));
    }

}
