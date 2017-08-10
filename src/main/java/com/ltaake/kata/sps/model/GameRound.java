package com.ltaake.kata.sps.model;

/**
 * A game round.
 */
public class GameRound {

    private final Shape first;
    private final Shape second;
    private final Result result;

    GameRound(Shape first, Shape second, Result result) {
        this.first = first;
        this.second = second;
        this.result = result;
    }

    public Shape getFirst() {
        return first;
    }

    public Shape getSecond() {
        return second;
    }

    public Result getResult() {
        return result;
    }
}
