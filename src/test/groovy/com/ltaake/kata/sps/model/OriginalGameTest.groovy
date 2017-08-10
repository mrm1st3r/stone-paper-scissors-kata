package com.ltaake.kata.sps.model

import spock.lang.Specification
import spock.lang.Unroll

class OriginalGameTest extends Specification {

    def "same shapes should result in tie"() {
        given:
        def game = new OriginalGame()

        expect:
        Result.TIE == game.play(shape, shape)

        where:
        shape << Shape.values()
    }

    @Unroll
    def "#first should win against #second"() {
        given:
        def game = new OriginalGame()

        expect:
        Result.WIN == game.play(first, second)

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
        Result.LOSE == game.play(first, second)

        where:
        first           | second
        Shape.STONE     | Shape.PAPER
        Shape.PAPER     | Shape.SCISSORS
        Shape.SCISSORS  | Shape.STONE
    }

    def "should not accept well"() {
        given:
        def game = new OriginalGame()

        when:
        game.play(Shape.PAPER, Shape.WELL)

        then:
        thrown(IllegalArgumentException)
    }
}
