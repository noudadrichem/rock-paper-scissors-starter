package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import domain.rules.RockPaperScissors;

import static org.junit.jupiter.api.Assertions.*;

public class RockPaperScissorsTest {

    private static Stream<Arguments> provideMovesAndResults() {
        return Stream.of(
            Arguments.of(Move.ROCK, Move.SCISSORS, Result.WIN),
            Arguments.of(Move.ROCK, Move.ROCK, Result.DRAW),
            Arguments.of(Move.ROCK, Move.PAPER, Result.LOSE),

            Arguments.of(Move.PAPER, Move.ROCK, Result.WIN),
            Arguments.of(Move.PAPER, Move.PAPER, Result.DRAW),
            Arguments.of(Move.PAPER, Move.SCISSORS, Result.LOSE),

            Arguments.of(Move.SCISSORS, Move.PAPER, Result.WIN),
            Arguments.of(Move.SCISSORS, Move.SCISSORS, Result.DRAW),
            Arguments.of(Move.SCISSORS, Move.ROCK, Result.LOSE)
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideMovesAndResults")
    void verifyMovesAndResults(final Move mine, final Move theirs, final Result expectedResult) {
        final Rules game = new RockPaperScissors();
        final Result result = game.decide(mine, theirs);
        assertEquals(expectedResult, result);
    }


    // @Test
    // @DisplayName("Remove this test when setup works")
    // public void temporaryTest() {
    //     assertTrue(false, "If you see this, it works and you can remove this method!");
    // }

    // @Test
    // @DisplayName("Rock crushes scissors")
    // void rockCrushesScissors() {
    //     // arrange > act > Assert
    //     Rules game = new RockPaperScissors();
    //     Result result = game.decide(Move.ROCK, Move.SCISSORS);
    //     assertEquals(Result.WIN, result);
    // }

    // @Test
    // @DisplayName("Scissors cut paper")
    // void scissorscutsPaper() {
    //     // arrange > act > Assert
    //     Rules game = new RockPaperScissors();
    //     Result result = game.decide(Move.SCISSORS, Move.PAPER);
    //     assertEquals(Result.WIN, result);
    // }

    // @Test
    // @DisplayName("Paper covers rock")
    // void paperCoversRock() {
    //     // arrange > act > Assert
    //     Rules game = new RockPaperScissors();
    //     Result result = game.decide(Move.PAPER, Move.ROCK);
    //     assertEquals(Result.WIN, result);
    // }
}
