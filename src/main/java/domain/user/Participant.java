package domain.user;

import domain.card.Card;
import domain.game.Rule;
import java.util.ArrayList;
import java.util.List;

public class Participant {
    private final List<Card> cards = new ArrayList<>();
    private int score = 0;
    private int aceCount = 0;

    public void addCard(Card card) {
        increaseScore(card);
        increaseAceCount(card);
        cards.add(card);
    }

    private void increaseScore(Card card) {
        score += card.getScore();
    }

    private void increaseAceCount(Card card) {
        if (card.isAce()) {
            aceCount++;
        }
    }

    public int nowScore() {
        return score +
                Rule.ACE_SCORE.getValue() * Math.min(
                        (Rule.MAX_SCORE.getValue() - score) / Rule.ACE_SCORE.getValue(),
                        aceCount
                );
    }
}
