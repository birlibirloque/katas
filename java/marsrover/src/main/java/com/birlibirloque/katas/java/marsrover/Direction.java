package com.birlibirloque.katas.java.marsrover;

public enum Direction {
	North,East,South,West;
	
	public Direction turnRight () {
		Direction[] direction = Direction.values();
		int ordinal = this.ordinal();
		ordinal = ++ordinal % direction.length;
		return direction[ordinal];
	}

	public Direction turnLeft () {
		Direction[] direction = Direction.values();
		int ordinal = this.ordinal();
		ordinal = (ordinal + (direction.length - 1)) % direction.length;
		return direction[ordinal];
	}

	public boolean areYouFacing (Direction in) {
		return this.ordinal() == in.ordinal();
	}
}
