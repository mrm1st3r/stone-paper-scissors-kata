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
    public Result play(Shape first, Shape second) {
        if (!allowedShapes().contains(first) || !allowedShapes().contains(second)) {
            throw new IllegalArgumentException("Illegal shape played");
        }

        if (first.equals(second)) {
            return Result.TIE;
        } else if (winningCombinations().contains(new ShapeTuple(first, second))) {
            return Result.WIN;
        } else if (winningCombinations().contains(new ShapeTuple(second, first))) {
            return Result.LOSE;
        }

        throw new IllegalStateException("Shape combination not covered by rules");
    }
}
