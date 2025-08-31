package com.example.snl;

public final class GameRules {
private final Board board;


public GameRules(Board board) {
this.board = board;
}


/**
* Computes the new position from the current position and dice outcome.
*
* Rules:
* - If current == 100 → already won.
* - If current + dice > 100 → stay on current.
* - Else move to current + dice, then apply snakes/ladders.
* - If exactly 100 after move/jump → win.
*/
public int move(int currentPosition, int diceOutcome) {
Validation.requirePositionInRange(currentPosition);
Validation.requireDiceInRange(diceOutcome);

//already won
if (currentPosition == Board.END) {
return Board.END; 
}

//cannot go beyond the END
int tentative = currentPosition + diceOutcome;
if (tentative > Board.END) {
return currentPosition; 
}

int landed = board.applyJumps(tentative);
return landed;
}
}
