package controller;

import domain.game.BlackJack;
import domain.user.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import service.BlackjackService;
import view.Input;
import view.Output;

public class BlackjackController {

    private final Output output = new Output();
    private final Input input = new Input(output);
    private final BlackjackService blackjackService = new BlackjackService();

    public void run() {
        BlackJack blackJack = blackjackService.newBlackJackGame(setPlayers());
        cardDistribution(blackJack);
    }

    private List<Player> setPlayers() {
        List<String> playerNames = getCorrectValue(() -> blackjackService.validPlayerNames(input.player()));

        return new ArrayList<Player>() {{
            for (String playerName : playerNames) {
                add(getCorrectValue(() -> blackjackService.createPlayer(playerName, input.bettingMoney(playerName))));
            }
        }};
    }

    private void cardDistribution(BlackJack blackJack) {
        output.distribution(blackJack);
        blackJack.cardDistribution();
    }

    private <T> T getCorrectValue(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                output.error(e.getMessage());
                output.enter();
            }
        }
    }
}
