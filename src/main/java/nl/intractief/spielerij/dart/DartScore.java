package nl.intractief.spielerij.dart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

record DartScore(int score, ScoreType type) {
    static final List<DartScore> ALL = allPossibleScoresWithOneDart();

    static List<DartScore> allPossibleScoresWithOneDart() {
        List<DartScore> result = new ArrayList<>();
        for(int i=1;i<=20;i++) {
            result.add(new DartScore(i, ScoreType.SINGLE));
            //TODO: not complete
        }
        return result;
    }

    int berekenScore() {
        return score();
    }
}