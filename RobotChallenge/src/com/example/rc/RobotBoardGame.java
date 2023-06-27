package com.example.rc;

import java.util.ArrayList;
import java.util.List;

public class RobotBoardGame {
	private List<Robot> robotList = new ArrayList<>();
	private GameBoard board;
	private int activeRobot = -1;

	public RobotBoardGame(GameBoard board) {
		this.board = board;
	}

	public void placeRobot(int x, int y, Direction direction) {
		robotList.add(new Robot(new Position(x, y), direction));

		if (robotList.size() == 1) {
			this.activeRobot = 0;
		}
	}

	public void activateRobot(int identifier) {
		if (identifier > 0 && identifier <= robotList.size()) {
			this.activeRobot = identifier - 1;
		}
	}

	public void turnLeft() {
		if (!robotList.isEmpty())
			this.robotList.get(this.activeRobot).rotateLeft();
	}

	public void turnRight() {
		if (!robotList.isEmpty())
			this.robotList.get(this.activeRobot).rotateRight();
	}

	public void validateAndMove() {
		if (!robotList.isEmpty()) {
			Position newPosition = robotList.get(this.activeRobot).predictNextMove();
			if (board.isValidPosition(newPosition)) {
				robotList.get(this.activeRobot).setPosition(newPosition);
			}
		}

	}

	public void report() {
		for (int i = 0; i < robotList.size(); i++) {
			System.out.print("Robot " + (i + 1) + ": " + robotList.get(i).toString());
			if (i == activeRobot)
				System.out.print(" (Active)");
			System.out.println();
		}

	}

}
