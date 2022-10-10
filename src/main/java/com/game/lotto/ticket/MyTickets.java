package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTickets {
    private final List<MyTicket> myTickets;
    private final LottoNumberGenerator numberGenerator;

    public MyTickets(long tryCount, LottoNumberGenerator numberGenerator) {
        this.myTickets = new ArrayList<>();
        this.numberGenerator = numberGenerator;
        addRandomTicketsByCount(tryCount);
    }

    private void addRandomTicketsByCount(long tryCount) {
        for (int index = 0; index < tryCount; index++) {
            MyTicket randomMyTicket = new MyTicket(numberGenerator);
            ResultView.printTicketNumbers(randomMyTicket);
            this.myTickets.add(randomMyTicket);
        }
    }

    public List<MyTicket> getTickets() {
        return myTickets.stream().collect(Collectors.toUnmodifiableList());
    }
}
