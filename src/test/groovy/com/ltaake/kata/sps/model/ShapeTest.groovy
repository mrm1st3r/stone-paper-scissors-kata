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

    def "should not accept null"() {
        when:
        Shape.create(null)

        then:
        thrown(IllegalArgumentException)
    }

    def "should not accept unknown strings"() {
        when:
        Shape.create("foo")

        then:
        thrown(IllegalArgumentException)
    }
}
