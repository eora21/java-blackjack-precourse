package controller;

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
        List<Player> players = setPlayers();
    }

    private List<Player> setPlayers() {
        List<String> playerNames = getCorrectValue(() -> blackjackService.validPlayerNames(input.player()));

        return new ArrayList<Player>() {{
            for (String playerName : playerNames) {
                add(getCorrectValue(() -> blackjackService.createPlayer(playerName, input.bettingMoney(playerName))));
            }
        }};
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
