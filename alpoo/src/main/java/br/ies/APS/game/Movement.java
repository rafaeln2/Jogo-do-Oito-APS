package br.ies.APS.game;

import br.ies.APS.game.interfaces.Board;
import br.ies.APS.game.interfaces.Manipulator;

public class Movement implements Manipulator {
	private Board gameBoard;

	public Movement(Board gameBoard) {
		this.gameBoard = gameBoard; 
	}
	
	public void moveUP() {
		Integer[][] board = gameBoard.getStateOfBoard();
		Integer[] spaceCoordinates = gameBoard.findSpaceCoordinates();
		
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = board[axisX][axisY];
		
		if(axisX > gameBoard.getPropertiesOfBoard().getAxisXStart()) {
			Integer swap = board[axisX - 1][axisY];
			board[axisX - 1][axisY] = space;
			board[axisX][axisY] = swap;
		}
		
		gameBoard.setBoard(board);
	}
	
	public void moveRight() {
		Integer[][] board = gameBoard.getStateOfBoard();
		Integer[] spaceCoordinates = gameBoard.findSpaceCoordinates();
		
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = board[axisX][axisY];
		
		if(axisY < gameBoard.getPropertiesOfBoard().getAxisYLimit() - 1) {
			Integer swap = board[axisX][axisY + 1];
			board[axisX][axisY + 1] = space;
			board[axisX][axisY] = swap;
		}
		
		gameBoard.setBoard(board);
	}
	
	public void moveLeft() {
		Integer[][] board = gameBoard.getStateOfBoard();
		Integer[] spaceCoordinates = gameBoard.findSpaceCoordinates();
		
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = board[axisX][axisY];
		
		if(axisY > gameBoard.getPropertiesOfBoard().getAxisYStart()) {
			Integer swap = board[axisX][axisY - 1];
			board[axisX][axisY - 1] = space;
			board[axisX][axisY] = swap;
		}
		
		gameBoard.setBoard(board);
	}
	
	public void moveDown() {
		Integer[][] board = gameBoard.getStateOfBoard();
		Integer[] spaceCoordinates = gameBoard.findSpaceCoordinates();
		
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = board[axisX][axisY];
		
		if(axisX < gameBoard.getPropertiesOfBoard().getAxisXLimit() - 1) {
			Integer swap = board[axisX + 1][axisY];
			board[axisX + 1][axisY] = space;
			board[axisX][axisY] = swap;
		}
		
		gameBoard.setBoard(board);
	}
}
