package com.birlibirloque.katas.java.marsrover;

public class Possition {

	private int x = 0;
	private int y = 0;
	
	public Possition (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void fordward (Direction direction) {
		if (direction.areYouFacing(Direction.North)) {
			y = ++y;
		}

		else if (direction.areYouFacing(Direction.South)) {
			y = --y;
		}

		else if (direction.areYouFacing(Direction.East)) {
			x = ++x;
		}

		else if (direction.areYouFacing(Direction.West)) {
			x = --x;
		}		
	}

	public void backward (Direction direction) {
		if (direction.areYouFacing(Direction.North)) {
			y = --y;
		}

		else if (direction.areYouFacing(Direction.South)) {
			y = ++y;
		}

		else if (direction.areYouFacing(Direction.East)) {
			x = --x;
		}

		else if (direction.areYouFacing(Direction.West)) {
			x = ++x;
		}
	}

	public void startAt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean areAt(int x, int y) {
		return ((this.x == x) && (this.y == y));
	}
}
