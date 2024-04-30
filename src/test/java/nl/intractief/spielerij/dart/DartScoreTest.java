package nl.intractief.spielerij.dart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DartScoreTest {

    @CsvSource({
            "1,SINGLE,1",
            "20,TRIPLE,60",
            "19,TRIPLE,57",
            // hier kun je extra tests toevoegen
            "10,DOUBLE,20",
            "10,SINGLE,10"
    })
    @ParameterizedTest
    void berekenScore(int score, ScoreType type, int berekend) {
        DartScore dart = new DartScore(score,type);

        assertEquals(berekend,dart.berekenScore());
    }

    @Test
    void allForType() {
        var singles = DartScore.allForType(ScoreType.SINGLE).toList();

        assertEquals(20,singles.size());
    }

    @Test
    void alleDartScoresMet1PijlAantal() {
        assertEquals(62,DartScore.allPossibleScoresWithOneDart().count());
    }

    @Test
    void alleDartScoresMet1PijlSum() {
        assertEquals(1335,DartScore.allPossibleScoresWithOneDart().mapToInt(DartScore::berekenScore).sum());
    }
}
