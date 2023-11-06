package com.example.T1;

import com.example.T1.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service service;

    public ControllerTest() {
    }

    @BeforeEach
    public void setUp() {
        when(service.compute("aaaaabcccc")).thenReturn("\"a\": 5, \"c\": 4, \"b\": 1");
        when(service.compute("")).thenReturn("You entered an empty string");
    }

    @Test
    public void whenValidInput() throws Exception {
        mockMvc.perform(get("/countChars?input=aaaaabcccc"))
                .andExpect(status().isOk())
                .andExpect(content().string("\"a\": 5, \"c\": 4, \"b\": 1"));
    }

    @Test
    public void whenEmptyInput() throws Exception {
        mockMvc.perform(get("/countChars?input="))
                .andExpect(status().isOk())
                .andExpect(content().string("You entered an empty string"));
    }

}
