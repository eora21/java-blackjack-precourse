package view;

public class Output {

    public void requirePlayer() {
        print("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void requireBettingMoney(String playerName) {
        print(String.format("%s의 배팅 금액은?", playerName));
    }

    private void print(String text) {
        System.out.println(text);
    }

    public void enter() {
        System.out.println();
    }
}
