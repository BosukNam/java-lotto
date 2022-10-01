package com.game.lotto.play;

import com.game.lotto.ui.InputView;

public class LottoGameApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.playGame(InputView.inputPrice());
    }
}
