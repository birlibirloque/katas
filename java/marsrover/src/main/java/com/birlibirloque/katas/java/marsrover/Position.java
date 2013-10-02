package com.birlibirloque.katas.java.marsrover;

public class Position {

	private int x = 0;
	private int y = 0;
	
	public Position (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveStepsByDirection (int steps, Direction direction) {
		if (direction.areYouFacing(Direction.North)) {
			y += steps;
		}

		else if (direction.areYouFacing(Direction.South)) {
			y -= steps;
		}

		else if (direction.areYouFacing(Direction.East)) {
			x += steps;
		}

		else if (direction.areYouFacing(Direction.West)) {
			x -= steps;
		}		
	}

	public boolean areAt(int x, int y) {
		return ((this.x == x) && (this.y == y));
	}

	public void wrap (int xsize, int ysize) {
		if (x < 0)
			x += xsize;
		if (y < 0)
			y += ysize;
		x = x % xsize;
		y = y % ysize;
	}
}
