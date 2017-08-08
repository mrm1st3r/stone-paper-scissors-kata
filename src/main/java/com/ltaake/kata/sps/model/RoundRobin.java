package com.ltaake.kata.sps.model;

/**
 * A simple, predictive computer player that cycles trough
 * all possible shapes.
 */
public class RoundRobin implements ComputerPlayer {

    private int lastChosen = -1;

    @Override
    public Shape choose() {
        lastChosen ++;
        if (lastChosen >= Shape.values().length) {
            lastChosen = 0;
        }
        return Shape.values()[lastChosen];
    }
}
