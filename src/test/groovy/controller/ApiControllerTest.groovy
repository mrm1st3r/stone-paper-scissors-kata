package controller

import com.ltaake.kata.sps.controller.ApiController
import com.ltaake.kata.sps.model.ComputerPlayer
import com.ltaake.kata.sps.model.OriginalGame
import com.ltaake.kata.sps.model.Result
import com.ltaake.kata.sps.model.Shape
import spock.lang.Specification

class ApiControllerTest extends Specification {

    def "should play game"() {
        given:
        ComputerPlayer player = Mock()
        ApiController controller = new ApiController(new OriginalGame(), null, player, null)

        when:
        def result = controller.original(Shape.PAPER)

        then:
        result == Result.WIN
        1 * player.choose() >> Shape.STONE
    }
}
