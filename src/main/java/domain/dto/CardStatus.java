package domain.dto;

import domain.card.Card;
import java.util.List;
import java.util.stream.Collectors;

public class CardStatus {

    private final String name;
    private final List<String> cardDescriptions;

    public CardStatus(String name, List<Card> cards) {
        this.name = name;
        this.cardDescriptions = cards.stream().map(Card::getDistribution).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<String> getCardDescriptions() {
        return cardDescriptions;
    }
}
