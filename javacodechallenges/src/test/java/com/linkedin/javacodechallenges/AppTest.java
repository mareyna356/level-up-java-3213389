package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private static final String JOKE = "Knock knock!";

    private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();

    @Before
    public void setUpEach() {
        System.setOut(new PrintStream(printOut));
    }

    @After
    public void cleanUpEach() {
        System.setOut(System.out);
    }

    @Test
    public void parseJoke() {
        String joke = App.parseJoke("{\"id\":\"abc\",\"status\":200,\"joke\":\"" + JOKE + "\"}");
        assertTrue(joke.length() > 0);
        assertEquals(JOKE, joke);
    }

    @Test
    public void parseJoke_parseError() {

        String joke = App.parseJoke("today");
        assertFalse(joke.length() > 0);
        assertEquals("Must be out of jokes for now.\n", printOut.toString());
    }

    @Test
    public void parseJoke_noJokes() {

        String joke = App.parseJoke("[]");
        assertFalse(joke.length() > 0);
    }
}