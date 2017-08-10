package com.ltaake.kata.sps.model;

import java.util.Set;

/**
 * Interface for all game variations.
 */
public abstract class Game {

    abstract Set<Shape> allowedShapes();

    abstract Set<ShapeTuple> winningCombinations();

    /**
     * Decide a game round.
     */
    public GameRound play(Shape first, Shape second) {
        if (!allowedShapes().contains(first) || !allowedShapes().contains(second)) {
            throw new IllegalArgumentException("Illegal shape played");
        }
        Result result = null;
        if (first.equals(second)) {
            result = Result.TIE;
        } else if (winningCombinations().contains(new ShapeTuple(first, second))) {
            result = Result.WIN;
        } else if (winningCombinations().contains(new ShapeTuple(second, first))) {
            result = Result.LOSE;
        }

        if (result != null) {
            return new GameRound(first, second, result);
        }

        throw new IllegalStateException("Shape combination not covered by rules");
    }
}
