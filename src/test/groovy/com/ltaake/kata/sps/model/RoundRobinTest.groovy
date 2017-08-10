package com.ltaake.kata.sps.model

import spock.lang.Specification

class RoundRobinTest extends Specification {

    def "should cycle trough all shapes"() {
        given: "A new round robin"
        def game = new OriginalGame()
        def robin = new RoundRobin(game)
        def shapes = game.allowedShapes()

        expect: "cycles trough all shapes"
        for (Shape shape : shapes) {
            robin.choose() == shape
        }

        and: "and starts back at the beginning"
        for (Shape shape : shapes) {
            robin.choose() == shape
        }
    }
}
