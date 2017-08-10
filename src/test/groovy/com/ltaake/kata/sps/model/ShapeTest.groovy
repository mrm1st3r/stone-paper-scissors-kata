package com.ltaake.kata.sps.model

import spock.lang.Specification

class ShapeTest extends Specification {

    def "should create from JSON"() {
        expect:

        expected == Shape.create(string)

        where:
        expected        | string
        Shape.PAPER     | "PAPER"
        Shape.STONE     | "STONE"
        Shape.SCISSORS  | "SCISSORS"
        Shape.WELL      | "WELL"
    }
}
