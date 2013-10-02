package com.birlibirloque.katas.java.marsrover;

public class MarsRover 
{
	private Possition possition = null;
	private Direction direction = Direction.North;

	public MarsRover() {
		this.possition = new Possition(50, 50);
	}

	public MarsRover(int x, int y, String ad) {
		this.possition = new Possition(x, y);
		this.direction = Direction.valueOf(ad);
	}

	public boolean areYouAt (int x, int y, String ad) {
		return (possition.areAt(x, y) && (direction.areYouFacing(Direction.valueOf(ad))));
	}

	public void command (String commands) {
		for (int i = 0; i < commands.length(); i++) {
			if (commands.charAt(i) == 'f')
				this.possition.moveStepsByDirection(1,this.direction);
			else if (commands.charAt(i) == 'b')
				this.possition.moveStepsByDirection(-1,this.direction);
			else if (commands.charAt(i) == 'r')
				direction = direction.turnRight();
			else if (commands.charAt(i) == 'l')
				direction = direction.turnLeft();
		}
	}
}
