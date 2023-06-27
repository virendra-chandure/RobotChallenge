package com.example.rc;

public abstract class GameBoard {
	protected int rows;
	protected int cols;

	GameBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	protected boolean isValidPosition(Position position) {
		return position.getX() >= 0 && position.getX() < this.rows && position.getY() >= 0
				&& position.getY() < this.cols;

	}

}