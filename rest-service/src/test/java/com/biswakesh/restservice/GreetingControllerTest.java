package com.biswakesh.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void noParamGreeting() throws Exception {
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World"));
    }

    @Test
    public void paramGreeting() throws Exception {
        this.mockMvc.perform(get("/greeting").param("name","Bish")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Bish"));
    }

}
