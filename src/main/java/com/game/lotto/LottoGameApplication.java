package com.game.lotto;

import com.game.lotto.count.ManualLottoTicketCount;
import com.game.lotto.count.Number;
import com.game.lotto.money.Money;
import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.LottoNumbers;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.SelectedLottoNumbers;
import com.game.lotto.ticket.LottoTicket;
import com.game.lotto.ticket.PurchasedLottoTickets;
import com.game.lotto.play.LottoGame;
import com.game.lotto.ticket.WinnerTicket;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        // 1. 구매금액 입력
        Money purchaseMoney = new Money();

        // 2. 수동으로 구매할 로또 수 입력
        ManualLottoTicketCount manualLottoTicketCount = new ManualLottoTicketCount();

        // 3. 수동으로 구매할 번호 입력 + 수동/자동 로또 티켓 구매
        // 4. 수동/자동으로 구매한 로또 출력
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets(purchaseMoney, manualLottoTicketCount);

        // 5. 지난 주 당첨 번호 입력
        SelectedLottoNumbers winnerNumbers = new SelectedLottoNumbers(InputView.inputLastWinnerNumber());

        // 6. 보너스 볼 입력
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());

        // 7. 로또 게임 추첨 시작
        WinnerTicket winnerTicket = new WinnerTicket(winnerNumbers, bonusNumber);

        // 8. 당첨 통계 출력
        ResultView.printResultMessage();
        LottoGame lottoGame = new LottoGame(purchaseMoney, purchasedLottoTickets);
        ResultView.printGameResult(lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket));
    }
}
