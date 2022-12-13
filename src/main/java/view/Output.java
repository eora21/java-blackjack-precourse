package view;

public class Output {

    public void requirePlayer() {
        print("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    private void print(String text) {
        System.out.println(text);
    }

    public void enter() {
        System.out.println();
    }
}
