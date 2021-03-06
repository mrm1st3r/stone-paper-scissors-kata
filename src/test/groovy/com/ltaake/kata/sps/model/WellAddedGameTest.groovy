package com.ltaake.kata.sps.model

import spock.lang.Specification
import spock.lang.Unroll

class WellAddedGameTest extends Specification {

    def "same shapes should result in tie"() {
        given:
        def game = new WellAddedGame()

        expect:
        Result.TIE == game.play(shape, shape).getResult()

        where:
        shape << new WellAddedGame().allowedShapes()
    }

    @Unroll
    def "#first should win against #second"() {
        given:
        def game = new WellAddedGame()

        expect:
        Result.WIN == game.play(first, second).getResult()

        where:
        first           | second
        Shape.STONE     | Shape.SCISSORS
        Shape.PAPER     | Shape.STONE
        Shape.SCISSORS  | Shape.PAPER
        Shape.WELL      | Shape.STONE
        Shape.WELL      | Shape.SCISSORS
        Shape.PAPER     | Shape.WELL
    }

    @Unroll
    def "#first should lose against #second"() {
        given:
        def game = new WellAddedGame()

        expect:
        Result.LOSE == game.play(first, second).getResult()

        where:
        first           | second
        Shape.STONE     | Shape.PAPER
        Shape.PAPER     | Shape.SCISSORS
        Shape.SCISSORS  | Shape.STONE
        Shape.STONE     | Shape.WELL
        Shape.SCISSORS  | Shape.WELL
        Shape.WELL      | Shape.PAPER
    }
}
