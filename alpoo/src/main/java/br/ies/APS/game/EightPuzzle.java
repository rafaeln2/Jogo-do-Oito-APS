package br.ies.APS.game;

import java.util.Random;

public class EightPuzzle {
	private static Integer[][] table = { {1, 2, 3}, {7, 4, 6}, {8, 5, 0} };
	private static Random random;
	private Integer swap;
	
	private static void setUp() {
		//to setup random numbers in table
	}
	
	private Integer[] findSpaceCoordinates(Integer[][] table) {
		for(Integer line = 0; line < 3; line++) {
			for(Integer column = 0; column < 3; column++) {
				if(table[line][column] == 0) {
					Integer[] coordinates = {line, column};
					return coordinates;
				}
			}
		}
		return null;
	}
	
	public void moveUP() {
		Integer[] spaceCoordinates = findSpaceCoordinates(table);
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = table[axisX][axisY];
		
		if(axisX > 0) {
			swap = table[axisX - 1][axisY];
			table[axisX - 1][axisY] = space;
			table[axisX][axisY] = swap;
		}
	}
	
	public void moveRight() {
		Integer[] spaceCoordinates = findSpaceCoordinates(table);
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = table[axisX][axisY];
		
		if(axisY < 2) {
			swap = table[axisX][axisY + 1];
			table[axisX][axisY + 1] = space;
			table[axisX][axisY] = swap;
		}
	}
	
	public void moveLeft() {
		Integer[] spaceCoordinates = findSpaceCoordinates(table);
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = table[axisX][axisY];
		
		if(axisY > 0) {
			swap = table[axisX][axisY - 1];
			table[axisX][axisY - 1] = space;
			table[axisX][axisY] = swap;
		}
	}
	
	public void moveDown() {
		Integer[] spaceCoordinates = findSpaceCoordinates(table);
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = table[axisX][axisY];
		
		if(axisX < 2) {
			swap = table[axisX + 1][axisY];
			table[axisX + 1][axisY] = space;
			table[axisX][axisY] = swap;
		}
	}
	
	public Integer[][] getStatus() {
		return EightPuzzle.table;
	}
	
	public void printStatus() {
		for(Integer line = 0; line < 3; line++) {
			System.out.print("|");
			for(Integer column = 0; column < 3; column++) {
				System.out.print(" "+ table[line][column]);
			}
			System.out.println(" |");
		}
	}
	
	static void shuffle(Integer array[], long seed) {
        Integer index;
        // Shuffle array
        for (Integer i= array.length; i>1; i--){
            index = Integer.valueOf((int) Math.abs( seed % i ));
            //swap
            Integer tmp = array[i-1];
            array[i-1] = array[index];
            array[index] = tmp;
        }
    }
}
