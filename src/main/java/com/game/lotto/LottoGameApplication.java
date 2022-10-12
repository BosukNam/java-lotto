package com.game.lotto;

import com.game.lotto.count.TicketCount;
import com.game.lotto.money.Money;
import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.SelectedLottoNumbers;
import com.game.lotto.play.LottoGame;
import com.game.lotto.ticket.WinnerTicket;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        Money inputPrice = InputView.inputPrice();
        TicketCount manualLottoCount = InputView.inputManualLottoCount();
        List<SelectedLottoNumbers> manualLottoNumbers = InputView.inputManualLottoNumber(manualLottoCount);
        LottoGame lottoGame = new LottoGame(inputPrice, manualLottoNumbers);

        List<LottoNumber> winnerNumbers = InputView.inputLastWinnerNumber();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(winnerNumbers), bonusNumber);
        ResultView.printResultMessage();
        lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket);
    }
}
