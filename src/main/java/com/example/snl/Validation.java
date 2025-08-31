package com.example.snl;

public final class Validation {
private Validation() {}


public static void requireDiceInRange(int dice) {
if (dice < 1 || dice > 6) {
throw new IllegalArgumentException("Dice outcome must be between 1 and 6.");
}
}


public static void requirePositionInRange(int pos) {
if (pos < 0 || pos > 100) {
throw new IllegalArgumentException("Current position must be between 0 and 100.");
}
}
}
