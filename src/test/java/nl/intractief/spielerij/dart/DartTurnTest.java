package nl.intractief.spielerij.dart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DartTurnTest {

    @ParameterizedTest
    @CsvSource({
            "SINGLE,TRIPLE,DOUBLE",
            "SINGLE,SINGLE,DOUBLE",
            "TRIPLE,TRIPLE,DOUBLE",
            "TRIPLE,DOUBLE,",
            "TRIPLE,DOUBLE,",
            "DOUBLE,,"
    })
    void lastIsDouble(ScoreType first,ScoreType second,ScoreType third) {
        var firstDart = Optional.ofNullable(first).map(t -> new DartScore(1,t)).orElse(null);
        var secondDart = Optional.ofNullable(second).map(t -> new DartScore(1,t)).orElse(null);
        var thirtDart = Optional.ofNullable(third).map(t -> new DartScore(1,t)).orElse(null);

        var turn = new DartTurn(firstDart,secondDart,thirtDart);

        assertTrue(turn.lastIsDouble());
    }

    @ParameterizedTest
    @CsvSource({
            "6,SINGLE,TRIPLE,DOUBLE,36",
            "2,SINGLE,SINGLE,DOUBLE,8",
            "20,TRIPLE,TRIPLE,DOUBLE,160",
            "1,TRIPLE,DOUBLE,,5",
            "9,TRIPLE,DOUBLE,,45",
            "2,DOUBLE,,,4"
    })
    void berekenScore(int base,ScoreType first,ScoreType second,ScoreType third,int expected) {
        var firstDart = Optional.ofNullable(first).map(t -> new DartScore(base,t)).orElse(null);
        var secondDart = Optional.ofNullable(second).map(t -> new DartScore(base,t)).orElse(null);
        var thirtDart = Optional.ofNullable(third).map(t -> new DartScore(base,t)).orElse(null);

        var turn = new DartTurn(firstDart,secondDart,thirtDart);

        assertEquals(expected,turn.berekenScore());
    }


    @Test
    void possibilitiesWithOneDart() {
        var turns = DartTurn.possibilitiesWithOneDart().toList();

        assertEquals(62,turns.size());
    }

    @Test
    void possibilitiesWithTwoDarts() {
        var turns = DartTurn.possibilitiesWithTwoDarts().toList();

        assertEquals(62*62,turns.size());
    }

    @Test
    void possibilitiesWithThreeDarts() {
        var turns = DartTurn.possibilitiesWithThreeDarts().toList();

        assertEquals(62*62*62,turns.size());
    }

    @Test
    void all() {
        long count = 62;
        count+= 62*62;
        count+= 62*62*62;

        assertEquals(count,DartTurn.all().count());
    }

    @ParameterizedTest
    @CsvSource({
            "5,10",
            "10,9",
            "90,1337"
    })
    void mogelijkeFinishesVanaf(int startScore,int mogelijkeFinishes) {
        //FIXME: hoeveel mogelijke finishes zijn er vanaf start score

        //FIXME: verzin (of filter) alle mogelijke scores vanaf start score
        List<DartTurn> beurten = DartTurn.all()
                .filter(DartTurn::lastIsDouble)
                .toList();//ntb

        assertEquals(mogelijkeFinishes,beurten.size());
    }
}