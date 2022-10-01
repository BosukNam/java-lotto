package com.game.lotto.play;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.rate.EarningRates;
import com.game.lotto.ticket.Ticket;
import com.game.lotto.ticket.MyTickets;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

public class LottoGame {
    private MyTickets myTickets;

    public double playGame(long inputPrice) {
        buyTickets(inputPrice);
        compareWithWinnerTicket();
        return getEarningRates(inputPrice);
    }

    private double getEarningRates(long inputPrice) {
        ResultView.printResultMessage();
        EarningRates earningRates = new EarningRates(inputPrice, myTickets);
        return earningRates.printResultsAndGetEarningRates();
    }

    private void compareWithWinnerTicket() {
        Ticket winnerTicket = new Ticket(new ManualLottoNumberGenerator(InputView.inputLastWinnerNumber()));
        myTickets.updateStrikesWithWinnerTicket(winnerTicket);
    }

    private void buyTickets(long inputPrice) {
        long ticketCount = inputMoneyAndGetTicketCount(inputPrice);
        myTickets = new MyTickets(ticketCount);
    }

    public long inputMoneyAndGetTicketCount(long inputPrice) {
        long ticketCount = inputPrice / Ticket.PRICE_OF_TICKET_UNIT;
        ResultView.printOutputCountMessage(ticketCount);
        return ticketCount;
    }
}
