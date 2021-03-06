package com.ltaake.kata.sps.model

import spock.lang.Specification
import spock.lang.Unroll

class OriginalGameTest extends Specification {

    def "same shapes should result in tie"() {
        given:
        def game = new OriginalGame()

        expect:
        Result.TIE == game.play(shape, shape).getResult()

        where:
        shape << new OriginalGame().allowedShapes()
    }

    @Unroll
    def "#first should win against #second"() {
        given:
        def game = new OriginalGame()

        expect:
        Result.WIN == game.play(first, second).getResult()

        where:
        first           | second
        Shape.STONE     | Shape.SCISSORS
        Shape.PAPER     | Shape.STONE
        Shape.SCISSORS  | Shape.PAPER
    }

    @Unroll
    def "#first should lose against #second"() {
        given:
        def game = new OriginalGame()

        expect:
        Result.LOSE == game.play(first, second).getResult()

        where:
        first           | second
        Shape.STONE     | Shape.PAPER
        Shape.PAPER     | Shape.SCISSORS
        Shape.SCISSORS  | Shape.STONE
    }

    def "should not accept well"() {
        given:
        def game = new OriginalGame()

        when: "second player uses well"
        game.play(Shape.PAPER, Shape.WELL)

        then:
        thrown(IllegalArgumentException)

        and:
        when: "first player uses well"
        game.play(Shape.WELL, Shape.STONE)

        then:
        thrown(IllegalArgumentException)
    }
}
