package com.ltaake.kata.sps.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enum containing all shapes allowed to play.
 */
public enum Shape {

    STONE,
    PAPER,
    SCISSORS;

    @Override
    public String toString() {
        return this.name();
    }

    @JsonCreator
    public static Shape create(String value) {
        if(value == null) {
            throw new IllegalArgumentException();
        }
        for(Shape s : values()) {
            if(value.equals(s.name())) {
                return s;
            }
        }
        throw new IllegalArgumentException();
    }
}
