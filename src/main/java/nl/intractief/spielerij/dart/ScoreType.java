package nl.intractief.spielerij.dart;

public enum ScoreType {
    SINGLE(1),
    DOUBLE(2),
    TRIPLE(3);

    private final int multiplier;

    ScoreType(int multiplier) {
        this.multiplier = multiplier;
    }

    int multiplier() {
        return this.multiplier;
    }
}
