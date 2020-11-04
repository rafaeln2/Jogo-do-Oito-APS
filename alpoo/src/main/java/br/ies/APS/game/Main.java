package br.ies.APS.game;

import br.ies.APS.game.models.BoardSize;
import br.ies.APS.game.models.Player;

public class Main {
	
	
	public static void main(String[] args) {
		Player vitor = new Player("Vitor");
		Viewer viewer = new Viewer();
		GameBoard gameBoard = new GameBoard(BoardSize.MEDIUM);
		gameBoard.setViewer(viewer);
		gameBoard.setPlayer(vitor);
		
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