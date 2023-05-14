package pl.kostrowski.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class TestMvcWithContainer extends TestContainerConfig {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldSendGetRequest() throws Exception {
        mockMvc.perform(get("/test")).andExpect(status().isOk()).andExpect(content().string("test"));
        Thread.sleep(15000);
        System.out.println("aaa");
    }



}
