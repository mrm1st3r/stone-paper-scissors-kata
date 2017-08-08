package com.ltaake.kata.sps.model

import spock.lang.Specification

class RoundRobinTest extends Specification {

    def "should cycle trough all shapes"() {
        given: "A new round robin"
        def robin = new RoundRobin()
        def shapes = Shape.values()

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
