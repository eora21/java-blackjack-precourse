package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player extends Participant {

    private static final int EMPTY_MONEY = 0;
    private final String name;
    private final double bettingMoney;

    private Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public static Player newInstance(String name, double bettingMoney) {
        if (bettingMoney <= EMPTY_MONEY) {
            throw new IllegalArgumentException("배팅 금액으로 적절하지 않은 값을 입력하셨습니다.");
        }

        return new Player(name, bettingMoney);
    }

    public String getName() {
        return name;
    }
}
