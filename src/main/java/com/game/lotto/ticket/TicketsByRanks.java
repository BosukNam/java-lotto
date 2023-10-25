package com.game.lotto.ticket;

import com.game.lotto.prize.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketsByRanks {
    private final Map<Rank, List<LottoTicket>> ticketsByRanks;

    public TicketsByRanks(WinnerTicket winnerTicket, LottoTickets lottoTickets) {
        this.ticketsByRanks = new HashMap<>();
        updateStrikesWithWinnerTicket(winnerTicket, lottoTickets);
    }

    private void updateStrikesWithWinnerTicket(WinnerTicket winnerTicket, LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getTickets()) {
            Rank rank = lottoTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
            addTicketsByRanks(rank, lottoTicket);
        }
    }

    private void addTicketsByRanks(Rank rank, LottoTicket lottoTicket) {
        ticketsByRanks.putIfAbsent(rank, new ArrayList<>());
        ticketsByRanks.get(rank).add(lottoTicket);
    }

    public List<LottoTicket> getTicketsByRank(Rank rank) {
        return ticketsByRanks.getOrDefault(rank, new ArrayList<>());
    }
}
