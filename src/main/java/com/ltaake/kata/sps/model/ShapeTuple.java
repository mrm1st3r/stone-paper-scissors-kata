package com.ltaake.kata.sps.model;

/**
 * An immutable tuple of shapes.
 */
public class ShapeTuple {
    private final Shape first;
    private final Shape second;

    ShapeTuple(Shape first, Shape second) {
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
