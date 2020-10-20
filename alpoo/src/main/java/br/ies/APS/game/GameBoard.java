package br.ies.APS.game;

import java.util.Random;

public class GameBoard {
	private static Integer[][] table = new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
	private static Random random;
	private static Integer axisYStart;
	private static Integer axisXStart;
	private static Integer axisYLimit;
	private static Integer axisXLimit;
	
	static {
		axisXStart = 0;
		axisYStart = 0;
		axisXLimit = GameBoard.table.length;
		axisYLimit = GameBoard.table.length;
	}
	
	public static Integer[] findSpaceCoordinates() {
		for(Integer line = 0; line < axisXLimit; line++) {
			for(Integer column = 0; column < axisYLimit; column++) {
				if(GameBoard.table[line][column] == 0) {
					Integer[] coordinates = {line, column};
					return coordinates;
				}
			}
		}
		return null;
	}

	public static void printStatus() {
		for(Integer line = 0; line < 3; line++) {
			System.out.print("|");
			for(Integer column = 0; column < 3; column++) {
				System.out.print(" "+ table[line][column]);
			}
			System.out.println(" |");
		}
	}
	
	public static Integer[][] getStatus() {
		return GameBoard.table;
	}
	
	public static Integer getAxisYLimit() {
		return axisYLimit;
	}
	
	public static Integer getAxisXLimit() {
		return axisXLimit;
	}

	public static Integer getAxisYStart() {
		return axisYStart;
	}
	
	public static Integer getAxisXStart() {
		return axisXStart;
	}
	
	public static void setAxisYLimit(Integer axisYLimit) {
		GameBoard.axisYLimit = axisYLimit;
	}

	public static void setAxisXLimit(Integer axisXLimit) {
		GameBoard.axisXLimit = axisXLimit;
	}

	public static void setAxisYStart(Integer axisYStart) {
		GameBoard.axisYStart = axisYStart;
	}

	public static void setAxisXStart(Integer axisXStart) {
		GameBoard.axisXStart = axisXStart;
	}

	public static void setBoard(Integer[][] board) {
		table = board;
	}
}
