package com.example.rc;

public class Robot {
	private Position position;
	private Direction direction;

	public Robot(Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void rotateLeft() {
		this.direction = switch (this.direction) {
		case NORTH -> Direction.WEST;
		case WEST -> Direction.SOUTH;
		case SOUTH -> Direction.EAST;
		case EAST -> Direction.NORTH;
		};
	}

	public void rotateRight() {
		this.direction = switch (this.direction) {
		case NORTH -> Direction.EAST;
		case EAST -> Direction.SOUTH;
		case SOUTH -> Direction.WEST;
		case WEST -> Direction.NORTH;
		};
	}

	public Position predictNextMove() {
		return switch (this.direction) {
		case NORTH -> new Position(position.getX(), position.getY() + 1);
		case EAST -> new Position(position.getX() + 1, position.getY());
		case SOUTH -> new Position(position.getX(), position.getY() - 1);
		case WEST -> new Position(position.getX() - 1, position.getY());
		};
	}

	@Override
	public String toString() {
		return position.getX() + "," +position.getY() + "," + direction.name();
	}
	
	

}
