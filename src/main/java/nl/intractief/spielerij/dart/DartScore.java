package nl.intractief.spielerij.dart;

import java.util.ArrayList;
import java.util.List;

record DartScore(int score, ScoreType type) {
    static final List<DartScore> ALL = allPossibleScoresWithOneDart();

    static List<DartScore> allPossibleScoresWithOneDart() {
        List<DartScore> result = new ArrayList<>();
        for(int i=1;i<=20;i++) {
            result.add(new DartScore(i, ScoreType.SINGLE));
            result.add(new DartScore(i, ScoreType.DOUBLE));
            result.add(new DartScore(i, ScoreType.TRIPLE));
            //TODO: not complete
        }
        result.add(new DartScore(25,ScoreType.DOUBLE ));
        result.add(new DartScore(25,ScoreType.SINGLE));
        return result;
    }

    int berekenScore() {
        return score()* type().multiplier();
    }
}