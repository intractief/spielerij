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
    void alleDartScoresMet1Pijl() {
        var scores = DartScore.allPossibleScoresWithOneDart();

        assertEquals(62,scores.size());

        assertEquals(1335,scores.stream().mapToInt(DartScore::berekenScore).sum());
    }
}
