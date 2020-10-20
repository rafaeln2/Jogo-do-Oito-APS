package br.ies.APS.game;

public class Movement {
	
//	private boolean exceededLimit(Integer value) {
//		System.out.println(value);
//		if(value == axisXLimit - 1 && value == axisYLimit - 1 && value == 0) {
//			return true;
//		}
//		return false;
//	}
	
	public void moveUP() {
		Integer[][] board = GameBoard.getStatus();
		Integer[] spaceCoordinates = GameBoard.findSpaceCoordinates();
		
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = board[axisX][axisY];
		
		if(axisX > GameBoard.getAxisXStart()) {
			Integer swap = board[axisX - 1][axisY];
			board[axisX - 1][axisY] = space;
			board[axisX][axisY] = swap;
		}
		
		GameBoard.setBoard(board);
	}
	
	public void moveRight() {
		Integer[][] board = GameBoard.getStatus();
		Integer[] spaceCoordinates = GameBoard.findSpaceCoordinates();
		
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = board[axisX][axisY];
		
		if(axisY < GameBoard.getAxisYLimit() - 1) {
			Integer swap = board[axisX][axisY + 1];
			board[axisX][axisY + 1] = space;
			board[axisX][axisY] = swap;
		}
		
		GameBoard.setBoard(board);
	}
	
	public void moveLeft() {
		Integer[][] board = GameBoard.getStatus();
		Integer[] spaceCoordinates = GameBoard.findSpaceCoordinates();
		
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = board[axisX][axisY];
		
		if(axisY > GameBoard.getAxisYStart()) {
			Integer swap = board[axisX][axisY - 1];
			board[axisX][axisY - 1] = space;
			board[axisX][axisY] = swap;
		}
		
		GameBoard.setBoard(board);
	}
	
	public void moveDown() {
		Integer[][] board = GameBoard.getStatus();
		Integer[] spaceCoordinates = GameBoard.findSpaceCoordinates();
		
		Integer axisX = spaceCoordinates[0];
		Integer axisY = spaceCoordinates[1];
		
		Integer space = board[axisX][axisY];
		
		if(axisX < GameBoard.getAxisXLimit() - 1) {
			Integer swap = board[axisX + 1][axisY];
			board[axisX + 1][axisY] = space;
			board[axisX][axisY] = swap;
		}
		
		GameBoard.setBoard(board);
	}
}
