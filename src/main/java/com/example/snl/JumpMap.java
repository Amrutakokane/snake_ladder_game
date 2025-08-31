package com.example.snl;

import java.util.Map;

public final class JumpMap {

    private final Map<Integer, Integer> jumps;

    private JumpMap(Map<Integer, Integer> jumps) {
        this.jumps = jumps;
    }

//  ladders and snakes defined. 
    public static JumpMap defaultMap() {
        return new JumpMap(Map.ofEntries(
            // Ladders
            Map.entry(7, 33),
            Map.entry(21, 42),
            Map.entry(37, 85),
            Map.entry(51, 72),
            // Snakes
            Map.entry(36, 19),
            Map.entry(65, 35),
            Map.entry(87, 32),
            Map.entry(98, 78)
        ));
    }

//     Return destination if this cell is start of a jump; otherwise the same cell.
    public int resolve(int cell) {
        return jumps.getOrDefault(cell, cell);
    }

    // Get the full map of jumps. 
    public Map<Integer, Integer> asMap() {
        return jumps;
    }
}
