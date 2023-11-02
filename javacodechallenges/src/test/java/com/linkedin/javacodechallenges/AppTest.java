package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();
    private HashMap<String, Integer> example = new HashMap<String, Integer>(
            Map.of("Jessica Jones", 2, "Rebecca Johnson", 3, "Sarah Roberts", 1, "Rafa Marquez", 0));

    @Before
    public void setUpEach() {
        System.setOut(new PrintStream(printOut));
    }

    @After
    public void cleanUpEach() {
        System.setOut(System.out);
    }

    @Test
    public void testGetTicketHolders() throws Exception {
        HashMap<String, Integer> test = App.getTicketHolders("../ticketholders.csv");
        assertEquals(example, test);
    }
}
