package com.game.lotto.rate;

import com.game.lotto.money.Money;
import com.game.lotto.prize.Rank;
import com.game.lotto.ticket.MyTicket;
import com.game.lotto.ticket.TicketsByRanks;
import com.game.lotto.ui.ResultView;

import java.util.Arrays;
import java.util.List;

import static com.game.lotto.ui.ResultView.*;

public class EarningRates {
    private final Money totalAmountOfTicketMoney;
    private final Money totalAmountOfPrizeMoney;
    private final TicketsByRanks ticketsByRanks;

    public EarningRates(Money totalAmountOfTicketMoney, TicketsByRanks ticketsByRanks) {
        this.totalAmountOfTicketMoney = totalAmountOfTicketMoney;
        this.totalAmountOfPrizeMoney = new Money();
        this.ticketsByRanks = ticketsByRanks;
    }

    public double calculateEarningRatesAndPrintResults() {
        double earningRates = calculateEarningRates();
        printGameResult(earningRates);
        return earningRates;
    }

    private double calculateEarningRates() {
        calculateTotalPrize();
        return (double) totalAmountOfPrizeMoney.getAmount() / totalAmountOfTicketMoney.getAmount();
    }

    private void calculateTotalPrize() {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NONE))
                .forEach(rank -> totalAmountOfPrizeMoney.addAmount(getTotalAmountOfPrizeMoney(rank)));
    }

    private int getTotalAmountOfPrizeMoney(Rank rank) {
        List<MyTicket> ticketsByRanks = this.ticketsByRanks.getTicketsByRank(rank);
        int ticketsByRanksSize = ticketsByRanks.size();
        ResultView.printStrikesAndSize(rank, ticketsByRanksSize);
        return ticketsByRanksSize * rank.getMoneyAmount().getAmount();
    }

    private void printGameResult(double earningRates) {
        if (earningRates > 1) {
            ResultView.printEarningRatesAndMessage(earningRates, OUTPUT_RESULT_EARNING_RATE_HIGH_MESSAGE);
            return;
        }
        if (earningRates == 1) {
            ResultView.printEarningRatesAndMessage(earningRates, OUTPUT_RESULT_EARNING_RATE_EQUAL_MESSAGE);
            return;
        }
        ResultView.printEarningRatesAndMessage(earningRates, OUTPUT_RESULT_EARNING_RATE_LOW_MESSAGE);
    }
}
