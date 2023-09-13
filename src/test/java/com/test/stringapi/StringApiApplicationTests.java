package com.test.stringapi;

import com.test.stringapi.services.StringWrapperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StringApiApplicationTests {

    private StringWrapperService stringService;

    @BeforeEach
    public void setUp() {
        stringService = new StringWrapperService();
    }

    @Test
    public void testProcessString() {
        String input = "Hello World";
        String toLowerCase = "true";
        String containsSpace = "false";

        Map<String, Integer> result = stringService.processString(input, toLowerCase, containsSpace);

        assertNotNull(result);
        assertEquals(7, result.size());
        assertEquals(1, result.get("h"));
        assertEquals(1, result.get("e"));
        assertEquals(3, result.get("l"));
        assertEquals(2, result.get("o"));
        assertEquals(1, result.get("r"));
    }
}
