package com.example.snl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {
    private GameRules engine;

    @BeforeEach
    void setUp() {
        engine = new GameRules(new Board(JumpMap.defaultMap()));
    }

    @Test
    void moveNormalProgression() {
        assertEquals(9, engine.move(4, 5)); // 4 + 5 = 9
    }

    @Test
    void hitLadder() {
        assertEquals(85, engine.move(34, 3)); // 37 -> 85 ladder
    }

    @Test
    void hitSnake() {
        assertEquals(32, engine.move(83, 4)); // 87 -> 32 snake
    }

    @Test
    void cannotOvershoot100() {
        assertEquals(96, engine.move(96, 5)); // overshoot -> stay
    }

    @Test
    void exactWin() {
        assertEquals(100, engine.move(99, 1)); // exactly 100
    }

    @Test
    void alreadyWonStays100() {
        assertEquals(100, engine.move(100, 3)); // already won
    }

    @Test
    void invalidDiceThrows() {
        assertThrows(IllegalArgumentException.class, () -> engine.move(10, 0));
        assertThrows(IllegalArgumentException.class, () -> engine.move(10, 7));
    }

    @Test
    void invalidCurrentPositionThrows() {
        assertThrows(IllegalArgumentException.class, () -> engine.move(-1, 3));
        assertThrows(IllegalArgumentException.class, () -> engine.move(101, 3));
    }
    
    @Test
    void diceAtBounds() {
        assertDoesNotThrow(() -> engine.move(10, 1));
        assertDoesNotThrow(() -> engine.move(10, 6));
    }

    @Test
    void startAtZero() {
        assertEquals(1, engine.move(0, 1));
    }

    @Test
    void overshootFrom99() {
        assertEquals(99, engine.move(99, 2));
    }
}
