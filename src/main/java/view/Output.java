package view;

import domain.game.BlackJack;
import domain.game.Rule;
import domain.user.Player;
import java.util.stream.Collectors;

public class Output {

    public void requirePlayer() {
        print("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void requireBettingMoney(String playerName) {
        print(String.format("%s의 배팅 금액은?", playerName));
    }

    public void error(String text) {
        print(String.format("[ERROR] %s", text));
    }

    private void print(String text) {
        System.out.println(text);
    }

    public void enter() {
        System.out.println();
    }

    public void distribution(BlackJack blackJack) {
        print(String.format("%s와 %s에게 %d장을 나누었습니다.",
                blackJack.getDealerName(),
                blackJack.getPlayers()
                        .stream()
                        .map(Player::getName)
                        .collect(Collectors.joining(", ")),
                Rule.START_DISTRIBUTION_COUNT.getValue()));
    }
}
