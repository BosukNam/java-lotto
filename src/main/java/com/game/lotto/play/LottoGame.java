package com.game.lotto.play;

import com.game.lotto.count.Number;
import com.game.lotto.money.Money;
import com.game.lotto.rate.EarningRates;
import com.game.lotto.ticket.*;
import com.game.lotto.ui.ResultView;

public class LottoGame {
    private final Money inputPrice;
    private final LottoTickets purchasedLottoTickets;

    public LottoGame(Money inputPrice, PurchasedLottoTickets purchasedLottoTickets) {
        this.inputPrice = inputPrice;
        this.purchasedLottoTickets = purchasedLottoTickets.getPurchasedLottoTickets();
    }

    public double compareWithWinnerTicketAndGetEarningRates(WinnerTicket winnerTicket) {
        TicketsByRanks ticketsByRanks = new TicketsByRanks(winnerTicket, purchasedLottoTickets);
        return getEarningRates(ticketsByRanks);
    }

    private double getEarningRates(TicketsByRanks ticketsByRanks) {
        EarningRates earningRates = new EarningRates(inputPrice, ticketsByRanks);
        return earningRates.calculateEarningRatesAndPrintResults();
    }
}
