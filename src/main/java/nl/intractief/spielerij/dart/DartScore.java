package nl.intractief.spielerij.dart;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

record DartScore(int score, ScoreType type) {
    static final List<DartScore> ALL = allPossibleScoresWithOneDart().toList();

    static Stream<DartScore> allPossibleScoresWithOneDart() {
        var singles = IntStream.rangeClosed(1,20).mapToObj(i -> new DartScore(i, ScoreType.SINGLE));
        var doubles = IntStream.rangeClosed(1,20).mapToObj(i -> new DartScore(i, ScoreType.DOUBLE));
        var triples = IntStream.rangeClosed(1,20).mapToObj(i -> new DartScore(i, ScoreType.TRIPLE));
        var bulls = Stream.of(new DartScore(25,ScoreType.DOUBLE ),new DartScore(25,ScoreType.SINGLE));
        var singlesAndDoubles = Stream.concat(singles,doubles);
        var triplesAndBulls = Stream.concat(triples,bulls);
        return Stream.concat(singlesAndDoubles,triplesAndBulls);
    }

    int berekenScore() {
        return score()* type().multiplier();
    }

    @Override
    public String toString() {
        return type.toString().toLowerCase()+score;
    }
}