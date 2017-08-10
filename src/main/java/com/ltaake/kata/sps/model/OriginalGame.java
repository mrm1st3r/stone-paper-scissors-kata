package com.ltaake.kata.sps.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * The main game class that creates a result based on two given shapes.
 */
@Component
public class OriginalGame extends Game {

    private Set<ShapeTuple> winningCombination;

    public OriginalGame() {
        winningCombination = new HashSet<>();
        winningCombination.add(new ShapeTuple(Shape.SCISSORS, Shape.PAPER));
        winningCombination.add(new ShapeTuple(Shape.PAPER, Shape.STONE));
        winningCombination.add(new ShapeTuple(Shape.STONE, Shape.SCISSORS));
    }

    @Override
    Set<ShapeTuple> winningCombinations() {
        return winningCombination;
    }

    @Override
    public Set<Shape> allowedShapes() {
        Set<Shape> allowed = new HashSet<>();
        allowed.add(Shape.STONE);
        allowed.add(Shape.PAPER);
        allowed.add(Shape.SCISSORS);
        return allowed;
    }
}
