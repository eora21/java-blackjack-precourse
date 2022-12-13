package domain.game;

public enum Rule {
    START_DISTRIBUTION_COUNT(2),
    MAX_SCORE(21),
    ACE_SCORE(10);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
