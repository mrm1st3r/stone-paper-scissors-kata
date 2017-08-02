package com.ltaake.kata.sps.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The main game class that creates a result based on two given shapes.
 */
public class Game {

    private List<ShapeTuple> winningCombination;

    public Game() {
        winningCombination = new ArrayList<>();
        winningCombination.add(new ShapeTuple(Shape.SCISSORS, Shape.PAPER));
        winningCombination.add(new ShapeTuple(Shape.PAPER, Shape.STONE));
        winningCombination.add(new ShapeTuple(Shape.STONE, Shape.SCISSORS));
    }

    /**
     * Decide a game round.
     * @return 0 for tie, 1 if the first wins and 2 if second wins
     */
    public int play(Shape first, Shape second) {
        if (first.equals(second)) {
            return 0;
        }
        if (winningCombination.contains(new ShapeTuple(first, second))) {
            return 1;
        } else {
            return 2;
        }
    }

    private static class ShapeTuple {
        private final Shape first;
        private final Shape second;

        private ShapeTuple(Shape first, Shape second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ShapeTuple that = (ShapeTuple) o;

            return first == that.first && second == that.second;
        }

        @Override
        public int hashCode() {
            int result = first.hashCode();
            result = 31 * result + second.hashCode();
            return result;
        }
    }
}
