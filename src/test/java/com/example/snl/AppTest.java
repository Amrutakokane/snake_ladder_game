package com.example.snl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void usageMessageIfNoArgs() {
        App.main(new String[]{});
        assertTrue(outContent.toString().contains("two arguments are required"));
    }

    @Test
    void invalidArgsNonInteger() {
        App.main(new String[]{"a", "b"});
        assertTrue(outContent.toString().contains("Both arguments must be integers."));
    }

    @Test
    void validNormalMove() {
        App.main(new String[]{"4", "5"});
        assertTrue(outContent.toString().contains("New position: 9"));
    }

    @Test
    void exactWinMessage() {
        App.main(new String[]{"99", "1"});
        assertTrue(outContent.toString().contains("Yay!! You won!!"));
    }

    @Test
    void overshootStaysSame() {
        App.main(new String[]{"96", "5"});
        assertEquals("96", outContent.toString().trim());
    }

    @Test
    void hitSnakeFromApp() {
        App.main(new String[]{"83", "4"});
        assertTrue(outContent.toString().contains("New position: 32"));
    }

    @Test
    void hitLadderFromApp() {
        App.main(new String[]{"34", "3"});
        assertTrue(outContent.toString().contains("New position: 85"));
    }
    
    @Test
    void tooFewArgsShowsUsage() {
        App.main(new String[]{"10"});
        assertTrue(outContent.toString().contains("two arguments are required"));
    }

    @Test
    void tooManyArgsShowsUsage() {
        App.main(new String[]{"1", "2", "3"});
        assertTrue(outContent.toString().contains("two arguments are required"));
    }
}
