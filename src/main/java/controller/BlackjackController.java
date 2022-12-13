package controller;

import java.util.List;
import service.BlackjackService;
import view.Input;
import view.Output;

public class BlackjackController {

    private final Output output = new Output();
    private final Input input = new Input(output);
    private final BlackjackService blackjackService = new BlackjackService();

    public void run() {
        setPlayer();
    }

    private void setPlayer() {
        List<String> playerNames = blackjackService.validPlayerNames(input.player());
    }
}
