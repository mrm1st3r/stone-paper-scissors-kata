package com.ltaake.kata.sps.model

import spock.lang.Specification

class GameTest extends Specification {

    def "same shapes should result in tie"() {
        given:
        def game = new Game()

        expect:
        0 == game.play(shape, shape)

        where:
        shape << Shape.values()
    }

    def "paper should win against stone"() {
        given:
        def game = new Game()

        expect:
        1 == game.play(first, second)

        where:
        first | second
        Shape.STONE | Shape.SCISSORS
        Shape.PAPER | Shape.STONE
        Shape.SCISSORS | Shape.PAPER
    }
}
