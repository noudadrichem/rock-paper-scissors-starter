package domain.rules;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import domain.Move;
import domain.Result;
import domain.Rules;

public class RockPaperScissors implements Rules {
    @Override
    public Result decide(Move mine, Move theirs) {
        // the order of power as copied from the table in the doc.
        List<Move> powerOrder = Arrays.asList(Move.PAPER, Move.ROCK, Move.SCISSORS, Move.PAPER);
        if (mine.equals(theirs)) { // this is an instant draw
            return Result.DRAW;
        } else if (Collections.indexOfSubList(powerOrder, Arrays.asList(mine, theirs)) >= 0) {
            return Result.WIN;
        } else {
            return Result.LOSE;
        }
    }
}
