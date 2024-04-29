package nl.intractief.spielerij.dart;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public record DartTurn(DartScore first, DartScore second, DartScore third) {

    static Stream<DartTurn> all() {
        return Stream.concat(Stream.concat(
            possibilitiesWithOneDart(),
            possibilitiesWithTwoDarts()
        ),
            possibilitiesWithThreeDarts()
        );
    }

    static Stream<DartTurn> possibilitiesWithThreeDarts() {
        return possibilitiesWithTwoDarts()
                .flatMap(turn -> DartScore.ALL.stream()
                        .map(score -> new DartTurn(turn.first(),turn.second(),score))
                );
    }

    static Stream<DartTurn> possibilitiesWithTwoDarts() {
        return possibilitiesWithOneDart()
                .flatMap(turn -> DartScore.ALL.stream()
                        .map(score -> new DartTurn(turn.first(),score,null))
                );
    }

    static Stream<DartTurn> possibilitiesWithOneDart() {
        return DartScore.ALL.stream()
                .map(score -> new DartTurn(score,null,null));
    }

    private Stream<DartScore> darts() {
        return Stream.of(
                third(),
                second(),
                first()
        ).filter(Objects::nonNull);
    }

    private Optional<DartScore> last() {
        return darts().findFirst();
    }

    boolean lastIsDouble() {
        return last()
                .filter(s -> ScoreType.DOUBLE.equals(s.type()))
                .isPresent();
    }

    int score() {
        return darts().mapToInt(DartScore::score).sum();
    }
}
