package com.ltaake.kata.sps.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple, predictive computer player that cycles trough
 * all possible shapes.
 */
public class RoundRobin implements ComputerPlayer {

    private final List<Shape> allowedShapes;
    private int lastChosen = -1;

    public RoundRobin(Game original) {
        this.allowedShapes = new ArrayList<>(original.allowedShapes());
    }

    @Override
    public Shape choose() {
        lastChosen ++;
        if (lastChosen >= allowedShapes.size()) {
            lastChosen = 0;
        }
        return allowedShapes.get(lastChosen);
    }
}
