package com.example.snl;

public final class App {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("two arguments are required currentPosition and diceOutcome");
            return; 
        }
        try {
            int current = Integer.parseInt(args[0]);
            int dice = Integer.parseInt(args[1]);

            Validation.requirePositionInRange(current);
            Validation.requireDiceInRange(dice);

            Board board = new Board(JumpMap.defaultMap());
            GameRules engine = new GameRules(board);

            int next = engine.move(current, dice);

            if (next == 100) {
                System.out.println("Yay!! You won!!");
                return;
            }

            if (next == current && current + dice > 100) {
                System.out.println(current);
                return;
            }

            System.out.println("New position: " + next);
        } catch (NumberFormatException ex) {
            System.out.println("Both arguments must be integers.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
