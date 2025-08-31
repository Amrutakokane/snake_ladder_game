package com.example.snl;

public final class Board {
	public static final int START = 0;
	public static final int END = 100;

	private final JumpMap jumpMap;

	public Board(JumpMap jumpMap) {
		this.jumpMap = jumpMap;
	}

	public int applyJumps(int cell) {
		return jumpMap.resolve(cell);
	}
}