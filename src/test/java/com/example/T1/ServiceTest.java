package com.example.T1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    public void whenComputeCalledWithValidString() {
        Service service = new Service();

        String input = "aaaaabcccc";
        String expected = "\"a\": 5, \"c\": 4, \"b\": 1";
        String actual = service.compute(input);

        assertEquals(expected, actual);
    }

    @Test
    public void whenComputeCalledWithEmptyString() {
        Service service = new Service();

        String input = "";
        String expected = "";
        String actual = service.compute(input);

        assertEquals(expected, actual);
    }

    @Test
    public void whenComputeCalledWithSingleCharString() {
        Service service = new Service();

        String input = "a";
        String expected = "\"a\": 1";
        String actual = service.compute(input);

        assertEquals(expected, actual);
    }

    @Test
    public void whenComputeCalledWithNonAlphabeticChars() {
        Service service = new Service();

        String input = "112233";
        String expected = "\"1\": 2, \"2\": 2, \"3\": 2";
        String actual = service.compute(input);

        assertEquals(expected, actual);
    }

}