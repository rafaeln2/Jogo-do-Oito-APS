package br.ies.APS.game;

import br.ies.APS.game.models.BoardSize;

public class Main {
	
	
	public static void main(String[] args) {
		GameBoard gameBoard = new GameBoard(BoardSize.MEDIUM);
		Movement movement = new Movement(gameBoard);
		
		VictoryCheck victoryCheck = new VictoryCheck();
		gameBoard.addObserver(victoryCheck);
		
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