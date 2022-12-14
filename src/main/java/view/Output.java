package view;

import domain.dto.CardStatus;
import domain.game.BlackJack;
import domain.game.Rule;

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
                String.join(", ", blackJack.getPlayerNames()),
                Rule.START_DISTRIBUTION_COUNT.getValue()));
    }

    public void cardState(BlackJack blackJack) {
        for (CardStatus cardStatus : blackJack.getAllCardStatus()) {
            print(String.format("%s: %s", cardStatus.getName(),
                    String.join(", ", cardStatus.getCardDescriptions())));
        }
    }
}
