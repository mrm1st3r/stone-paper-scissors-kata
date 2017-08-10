package com.ltaake.kata.sps.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Game variant allowing usage of wells.
 */
@Component
public class WellAddedGame extends Game {
    @Override
    Set<Shape> allowedShapes() {
        Set<Shape> shapes = new HashSet<>();
        shapes.add(Shape.STONE);
        shapes.add(Shape.PAPER);
        shapes.add(Shape.SCISSORS);
        shapes.add(Shape.WELL);
        return shapes;
    }

    @Override
    Set<ShapeTuple> winningCombinations() {
        Set<ShapeTuple> winningCombination = new HashSet<>();
        winningCombination.add(new ShapeTuple(Shape.SCISSORS, Shape.PAPER));
        winningCombination.add(new ShapeTuple(Shape.PAPER, Shape.STONE));
        winningCombination.add(new ShapeTuple(Shape.STONE, Shape.SCISSORS));
        winningCombination.add(new ShapeTuple(Shape.WELL, Shape.STONE));
        winningCombination.add(new ShapeTuple(Shape.WELL, Shape.SCISSORS));
        winningCombination.add(new ShapeTuple(Shape.PAPER, Shape.WELL));
        return winningCombination;
    }
}
