package com.game.lotto.rate;

import com.game.lotto.prize.PrizeByStrikesEnum;
import com.game.lotto.ticket.Ticket;
import com.game.lotto.ticket.MyTickets;
import com.game.lotto.ui.ResultView;

import java.util.List;

public class EarningRates {
    private MyTickets myTickets;
    private long totalAmountOfTicketMoney;
    private long totalAmountOfPrizeMoney;

    public EarningRates(long totalAmountOfTicketMoney, MyTickets myTickets) {
        this.totalAmountOfTicketMoney = totalAmountOfTicketMoney;
        this.myTickets = myTickets;
    }

    public double printResultsAndGetEarningRates() {
        double earningRates = calculateEarningRates();
        if(earningRates > 1) {
            ResultView.printEarningRatesWithHigh(earningRates);
            return earningRates;
        }
        ResultView.printEarningRatesWithLow(earningRates);
        return earningRates;
    }

    private double calculateEarningRates() {
        calculateTotalPrize();
        return (double) totalAmountOfPrizeMoney / totalAmountOfTicketMoney;
    }

    private void calculateTotalPrize() {
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(PrizeByStrikesEnum.FOURTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(PrizeByStrikesEnum.THIRD_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(PrizeByStrikesEnum.SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(PrizeByStrikesEnum.FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES);
    }

    private long getTotalAmountOfPrizeMoney(PrizeByStrikesEnum prizeByStrikesEnum) {
        List<Ticket> ticketsByStrikes = myTickets.getTicketsByStrikes(prizeByStrikesEnum.getStrikes());
        int ticketsByStrikesSize = ticketsByStrikes.size();
        ResultView.printStrikesAndSize(prizeByStrikesEnum, ticketsByStrikesSize);
        return ticketsByStrikesSize * prizeByStrikesEnum.getMoneyAmount();
    }
}
