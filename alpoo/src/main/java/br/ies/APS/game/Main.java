package br.ies.APS.game;

public class Main {
	
	
	public static void main(String[] args) {
		GameBoard gameBoard = new GameBoard(new Integer[][] { {1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10, 11, 6} });
		Movement movement = new Movement(gameBoard);
		
		gameBoard.printStatus();
		System.out.println("\nCIMA");
		movement.moveUP();
		gameBoard.printStatus();
		
		System.out.println("\nBAIXO");
		movement.moveDown();
		gameBoard.printStatus();
		
		System.out.println("\nBAIXO");
		movement.moveDown();
		gameBoard.printStatus();
		
		System.out.println("\nCIMA");
		movement.moveUP();
		gameBoard.printStatus();
		
		System.out.println("\nDIREITA");
		movement.moveRight();
		gameBoard.printStatus();
		
		System.out.println("\nESQUERDA");
		movement.moveLeft();
		gameBoard.printStatus();
		
		System.out.println("\nESQUERDA");
		movement.moveLeft();
		gameBoard.printStatus();
		
		System.out.println("\nDIREITA");
		movement.moveRight();
		gameBoard.printStatus();
	}
}