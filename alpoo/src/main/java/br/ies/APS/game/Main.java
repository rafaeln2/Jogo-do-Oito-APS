package br.ies.APS.game;

public class Main {
	
	
	public static void main(String[] args) {
		Movement movement = new Movement();
		
		GameBoard.printStatus();
		System.out.println("\nCIMA");
		movement.moveUP();
		GameBoard.printStatus();
		System.out.println("\nBAIXO");
		movement.moveDown();
		GameBoard.printStatus();
		System.out.println("\nDIREITA");
		movement.moveRight();
		GameBoard.printStatus();
		System.out.println("\nESQUERDA");
		movement.moveLeft();
		GameBoard.printStatus();
	}
}