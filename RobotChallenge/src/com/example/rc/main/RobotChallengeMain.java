/**
 * 
 */
package com.example.rc.main;

import java.util.Scanner;

import com.example.rc.Direction;
import com.example.rc.RobotBoardGame;
import com.example.rc.SquareGameBoard;

/**
 * @author virendra
 *
 */
public class RobotChallengeMain {

	final private static String INVALID_COMMAND_ERROR = "Invalid Command! Please try again.";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Application can read the commands of the following form\n" + "\n" + "PLACE X,Y,F\n"
				+ "MOVE\n" + "LEFT\n" + "RIGHT\n" + "REPORT\n" + "ROBOT <number>\n" + "EXIT\n\n"
				+ "Where PLACE will put the toy robot on the table with incrementing number identifier in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner.\n"
				+ "Where MOVE will move the toy robot one unit forward in the direction it is currently facing.\n"
				+ "Where LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.\n"
				+ "Where REPORT will announce the X,Y and facing of the robots and which robot is active\n"
				+ "A ROBOT <number> command will make the robot identified by active i.e. subsequent commands will affect that robot's position/direction. Any command that affects position/direction will affect only the active robot."
				+ "A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands. By default the first robot placed will become the active robot.");

		System.out.println("\nPlease enter command to execute: \n");

		RobotBoardGame game = new RobotBoardGame(new SquareGameBoard(5));

		Scanner sc = new Scanner(System.in);
		loop: while (sc.hasNextLine()) {
			String[] command = sc.nextLine().split(" ");
			try {
				switch (command[0].toUpperCase()) {
				case "EXIT":
					break loop;
				case "PLACE":
					String[] pos = command[1].split(",");
					game.placeRobot(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]),
							Direction.valueOf(pos[2].toUpperCase()));
					break;
				case "MOVE":
					game.validateAndMove();
					break;
				case "LEFT":
					game.turnLeft();
					break;
				case "RIGHT":
					game.turnRight();
					break;
				case "REPORT":
					game.report();
					break;
				case "ROBOT":
					game.activateRobot(Integer.parseInt(command[1]));
					break;
				default:
					printError();

				}
			} catch (Exception e) {
				printError();
			}
		}
	}

	private static void printError() {
		System.err.println(INVALID_COMMAND_ERROR);
	}

}
