package nl.intractief.spielerij.dart;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

record DartScore(int score, ScoreType type) {
    static final List<DartScore> ALL = allPossibleScoresWithOneDart().toList();

    static Stream<DartScore> allPossibleScoresWithOneDart() {
        var singlesAndDoubles = Stream.concat(
                allForType(ScoreType.SINGLE),
                allForType(ScoreType.DOUBLE));
        var triplesAndBulls = Stream.concat(
                allForType(ScoreType.TRIPLE),
                Stream.of(new DartScore(25,ScoreType.DOUBLE ),new DartScore(25,ScoreType.SINGLE)));
        return Stream.concat(singlesAndDoubles,triplesAndBulls);
    }

    static Stream<DartScore> allForType(ScoreType type) {
        return IntStream.rangeClosed(1, 20)
                .mapToObj(i -> new DartScore(i, type));
    }

    int berekenScore() {
        return score()* type().multiplier();
    }

    @Override
    public String toString() {
        return type.toString().toLowerCase()+score;
    }
}