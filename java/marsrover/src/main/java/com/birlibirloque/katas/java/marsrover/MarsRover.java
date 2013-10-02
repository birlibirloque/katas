package com.birlibirloque.katas.java.marsrover;

public class MarsRover 
{
	private Position position = null;
	private Direction direction = Direction.North;
	private Grid grid = null;

	public MarsRover(int x, int y, String ad, Grid grid) {
		this.position = new Position(x, y);
		this.direction = Direction.valueOf(ad);
		this.grid = grid;
	}

	public boolean areYouAt (int x, int y, String ad) {
		return (position.areAt(x, y) && (direction.areYouFacing(Direction.valueOf(ad))));
	}

	public void command (String commands) {
		for (int i = 0; i < commands.length(); i++) {
			if (commands.charAt(i) == 'f') {
				this.position.moveStepsByDirection(1,this.direction);
				grid.wrap(this.position);
			}
			else if (commands.charAt(i) == 'b') {
				this.position.moveStepsByDirection(-1,this.direction);
				grid.wrap(this.position);
			}
			else if (commands.charAt(i) == 'r')
				direction = direction.turnRight();
			else if (commands.charAt(i) == 'l')
				direction = direction.turnLeft();
		}
	}
}
