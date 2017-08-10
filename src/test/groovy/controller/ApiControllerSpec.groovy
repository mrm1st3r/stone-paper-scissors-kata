package controller

import com.ltaake.kata.sps.StonePaperScissorsKataApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = StonePaperScissorsKataApplication)
@AutoConfigureMockMvc
class ApiControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    @Unroll
    def "should reach #name REST endpoint"() {
        expect:
        mvc.perform(
                post("/play/" + name).content("\"STONE\"").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        )

        where:
        name << ["original", "wellAdded"]
    }
}
