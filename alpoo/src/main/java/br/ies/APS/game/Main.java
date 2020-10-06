package br.ies.APS.game;

public class Main {
	
	
	public static void main(String[] args) {
		EightPuzzle game = new EightPuzzle();
		game.printStatus();
		System.out.println("\nCIMA");
		game.moveUP();
		game.printStatus();
		System.out.println("\nBAIXO");
		game.moveDown();
		game.printStatus();
		System.out.println("\nDIREITA");
		game.moveRight();
		game.printStatus();
		System.out.println("\nESQUERDA");
		game.moveLeft();
		game.printStatus();
	}
}