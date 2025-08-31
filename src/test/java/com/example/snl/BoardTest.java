package com.example.snl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(JumpMap.defaultMap());
    }

    @Test
    void ladderApplied() {
        assertEquals(33, board.applyJumps(7));
        assertEquals(42, board.applyJumps(21));
    }

    @Test
    void snakeApplied() {
        assertEquals(19, board.applyJumps(36));
        assertEquals(32, board.applyJumps(87));
    }

    @Test
    void noJumpReturnsSameCell() {
        assertEquals(8, board.applyJumps(8));
    }
}
