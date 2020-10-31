package br.ies.APS.game;

import java.util.Random;

import br.ies.APS.game.interfaces.Board;
import br.ies.APS.game.models.BoardSize;

public class GameBoard implements Board {
	private BoardSize board;
	private Integer[][] stateOfBoard;
	private Viewer viewer;
	
	public GameBoard(BoardSize board) {
		this.board = board;
		this.stateOfBoard = new Integer[board.getAxisXLimit()][board.getAxisYLimit()];
		this.viewer = new Viewer(this);
		
		for(Integer line = 0; line < board.getAxisXLimit(); line++) {
			for(Integer column = 0; column < board.getAxisYLimit(); column++) {
				this.stateOfBoard[line][column] = board.getModel()[line][column];
			}
		}
		
		this.shuffle();
	}
	
	private void shuffle() {
		
		for(Integer[] line: this.stateOfBoard) {
			Random random = new Random();

			for (int i = 0; i < line.length - 1; i++) {
				int j = random.nextInt(this.stateOfBoard.length);
				
				int temp = line[i];
				line[i] = line[j];
				line[j] = temp;
			}
		}
	}
	
	public Integer[] findSpaceCoordinates() {
		for(Integer line = 0; line < this.board.getAxisXLimit(); line++) {
			for(Integer column = 0; column < this.board.getAxisYLimit(); column++) {
				if(this.stateOfBoard[line][column] == 0) {
					Integer[] coordinates = {line, column};
					return coordinates;
				}
			}
		}
		return null;
	}

	public void printStatus() {
		for(Integer line = 0; line < this.board.getAxisXLimit(); line++) {
			System.out.print("|");
			for(Integer column = 0; column < this.board.getAxisYLimit(); column++) {
				System.out.print(" "+ this.stateOfBoard[line][column]);
			}
			System.out.println(" |");
		}
	}
	
	public BoardSize getPropertiesOfBoard() {
		return board;
	}
	
	public Integer[][] getStateOfBoard() {
		return this.stateOfBoard;
	}

	public void setBoard(Integer[][] board) {
		this.stateOfBoard = board;
		
		this.viewer.notifyObservers();
	}
}
