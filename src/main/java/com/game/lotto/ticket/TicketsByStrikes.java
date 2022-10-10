package com.game.lotto.ticket;

import com.game.lotto.prize.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketsByStrikes {
    private final Map<Rank, List<MyTicket>> ticketsByStrikes;

    public TicketsByStrikes(WinnerTicket winnerTicket, final List<MyTicket> myTickets) {
        this.ticketsByStrikes = new HashMap<>();
        updateStrikesWithWinnerTicket(winnerTicket, myTickets);
    }

    private void updateStrikesWithWinnerTicket(WinnerTicket winnerTicket, List<MyTicket> myTickets) {
        for (MyTicket myTicket : myTickets) {
            Rank rank = myTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
            addTicketsByStrikes(rank, myTicket);
        }
    }

    public List<MyTicket> getTicketsByRank(Rank rank) {
        return ticketsByStrikes.getOrDefault(rank, new ArrayList<>());
    }

    private void addTicketsByStrikes(Rank rank, MyTicket myTicket) {
        if (ticketsByStrikes.containsKey(rank)) {
            ticketsByStrikes.get(rank).add(myTicket);
            return;
        }
        ticketsByStrikes.put(rank, new ArrayList<>());
        ticketsByStrikes.get(rank).add(myTicket);
    }
}
