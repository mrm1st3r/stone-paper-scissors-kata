package controller

import com.ltaake.kata.sps.StonePaperScissorsKataApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = StonePaperScissorsKataApplication)
@AutoConfigureMockMvc
class FrontendControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    def "should display web ui"() {
        expect:
        def result = mvc.perform(
                get("/")
        ).andExpect(
                status().isOk()
        ).andReturn()

        result.getResponse().getContentAsString().contains("<h1>Stone Paper Scissors</h1>")
    }
}
