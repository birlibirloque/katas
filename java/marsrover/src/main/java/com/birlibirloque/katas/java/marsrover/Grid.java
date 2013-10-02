package com.birlibirloque.katas.java.marsrover;

public class Grid {

	private int xsize = 0;
	private int ysize = 0;

	public Grid (int xsize, int ysize) {
		this.xsize = xsize;
		this.ysize = ysize;
	}

	public void wrap (Position position) {
		position.wrap(xsize,ysize);
	}
}