package domain.game;

import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Dealer;
import domain.user.Player;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BlackJack {

    private final Dealer dealer = new Dealer();
    private final List<Player> players;
    private final Queue<Card> cards;

    public BlackJack(List<Player> players) {
        this.players = players;
        List<Card> cards = new ArrayList<>(CardFactory.create());
        Collections.shuffle(cards);
        this.cards = new ArrayDeque<>(cards);
    }

    public void cardDistribution() {
        dealerDistribution();
        playersDistribution();
    }

    private void dealerDistribution() {
        dealer.addCard(cards.remove());
        dealer.addCard(cards.remove());
    }

    private void playersDistribution() {
        for (Player player : players) {
            player.addCard(cards.remove());
            player.addCard(cards.remove());
        }
    }
}
