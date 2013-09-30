package com.birlibirloque.katas.java.marsrover;

public class MarsRover 
{
	private enum Direction {
		North,East,South,West;
		
		public Direction right () {
			Direction[] direction = Direction.values();
			int ordinal = this.ordinal();
			ordinal = ++ordinal % direction.length;
			return direction[ordinal];
		}

		public Direction left () {
			Direction[] direction = Direction.values();
			int ordinal = this.ordinal();
			ordinal = (ordinal + (direction.length - 1)) % direction.length;
			return direction[ordinal];
		}

		public boolean isDirection (Direction in) {
			return this.ordinal() == in.ordinal();
		}
	}
	
	private int x = 50;
	private int y = 50;
	private Direction direction = Direction.North;

	public MarsRover() {
	}

	public MarsRover(int ax, int ay, String ad) {
		x = ax;
		y = ay;
		direction = Direction.valueOf(ad);
	}

	public boolean areYouAt (int ax, int ay, String ad) {
		return ((x == ax) && (y == ay) && (direction.name().equals(ad)));
	}

	public void command (String commands) {
		for (int i = 0; i < commands.length(); i++) {
			if (commands.charAt(i) == 'f')
				this.fordward();
			else if (commands.charAt(i) == 'b')
				this.backward();
			else if (commands.charAt(i) == 'r')
				direction = direction.right();
			else if (commands.charAt(i) == 'l')
				direction = direction.left();
		}
	}

	private void fordward () {
		if (direction.isDirection(Direction.North)) {
			y = ++y;
		}

		else if (direction.isDirection(Direction.South)) {
			y = --y;
		}

		else if (direction.isDirection(Direction.East)) {
			x = ++x;
		}

		else if (direction.isDirection(Direction.West)) {
			x = --x;
		}
	}

	private void backward () {
		if (direction.isDirection(Direction.North)) {
			y = --y;
		}

		else if (direction.isDirection(Direction.South)) {
			y = ++y;
		}

		else if (direction.isDirection(Direction.East)) {
			x = --x;
		}

		else if (direction.isDirection(Direction.West)) {
			x = ++x;
		}
	}
}
