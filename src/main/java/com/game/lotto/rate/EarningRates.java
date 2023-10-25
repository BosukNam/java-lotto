package com.game.lotto.rate;

import com.game.lotto.count.Number;
import com.game.lotto.money.Money;
import com.game.lotto.prize.Rank;
import com.game.lotto.ticket.LottoTicket;
import com.game.lotto.ticket.TicketsByRanks;
import com.game.lotto.ui.ResultView;

import java.util.Arrays;
import java.util.List;

public class EarningRates {
    private final Money totalAmountOfTicketMoney;
    private final Money totalAmountOfPrizeMoney;
    private final TicketsByRanks ticketsByRanks;

    public EarningRates(Money totalAmountOfTicketMoney, TicketsByRanks ticketsByRanks) {
        this.totalAmountOfTicketMoney = totalAmountOfTicketMoney;
        this.totalAmountOfPrizeMoney = new Money(new Number(0));
        this.ticketsByRanks = ticketsByRanks;
    }

    public double calculateEarningRatesAndPrintResults() {
        return calculateEarningRates();
    }

    private double calculateEarningRates() {
        calculateTotalPrize();
        return (double) totalAmountOfPrizeMoney.getValue() / totalAmountOfTicketMoney.getValue();
    }

    private void calculateTotalPrize() {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NONE))
                .forEach(rank -> totalAmountOfPrizeMoney.deposit(getTotalAmountOfPrizeMoney(rank)));
    }

    private int getTotalAmountOfPrizeMoney(Rank rank) {
        List<LottoTicket> ticketsByRanks = this.ticketsByRanks.getTicketsByRank(rank);
        int ticketsByRanksSize = ticketsByRanks.size();
        ResultView.printStrikesAndSize(rank, ticketsByRanksSize);
        return ticketsByRanksSize * rank.getMoneyAmount().getValue();
    }
}
