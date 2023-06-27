package com.example.rc;

public enum Direction {
	NORTH("NORTH"), EAST("EAST"), SOUTH("SOUTH"), WEST("WEST");

	public final String label;

	private Direction(String label) {
		this.label = label;
	}
}