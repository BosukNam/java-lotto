package com.game.lotto.ticket;

import com.game.lotto.count.ManualLottoTicketCount;
import com.game.lotto.count.Number;
import com.game.lotto.money.Money;
import com.game.lotto.money.TicketMoney;
import com.game.lotto.ui.ResultView;

public class PurchasedLottoTickets {
    private LottoTickets purchasedLottoTickets;
    public PurchasedLottoTickets(Money purchaseMoney, ManualLottoTicketCount manualLottoCount) {
        TicketMoney manualLottoTicketMoney = new TicketMoney(manualLottoCount);
        isEnoughToPurchaseManualLotto(purchaseMoney, manualLottoTicketMoney);
        this.purchasedLottoTickets = new ManualNumberLottoTickets(manualLottoCount);

        purchaseMoney.withdrawAmount(manualLottoCount.getValue() * LottoTicket.PRICE_OF_TICKET_UNIT);
        this.purchasedLottoTickets.addTickets(new RandomNumberLottoTickets(purchaseMoney).getTickets() );

        ResultView.printOutputCountMessage(manualLottoCount, purchasedLottoTickets);
    }

    public void isEnoughToPurchaseManualLotto(Money purchaseMoney, TicketMoney manualLottoTicketMoney) {
        if(purchaseMoney.compareTo(manualLottoTicketMoney) < 0) {
            throw new IllegalArgumentException("구매금액보다 많이 구매할 수 없습니다!");
        }
    }

    public LottoTickets getPurchasedLottoTickets() {
        return purchasedLottoTickets;
    }
}
