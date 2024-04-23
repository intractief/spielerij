package nl.intractief.spielerij.dart;

import java.util.ArrayList;
import java.util.List;

public record DartTurn(DartScore first, DartScore second, DartScore third) {

    static List<DartTurn> allPossibleTurnsWithThreeDarts() {
        List<DartTurn> turns = new ArrayList<>();
        for (DartScore score:DartScore.allPossibleScoresWithOneDart()) {
            turns.add(new DartTurn(score,null,null));
        }
        return turns;
    }

}
