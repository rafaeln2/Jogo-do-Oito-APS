package br.ies.APS.game;

import java.util.Random;

import br.ies.APS.game.interfaces.Board;

public class GameBoard implements Board {
	private Integer[][] board;
	private Random random;
	private Integer axisYStart;
	private Integer axisXStart;
	private Integer axisYLimit;
	private Integer axisXLimit;
	
	public GameBoard(Integer[][] board) {
		this.board = board;
		
		this.axisXStart = 0;
		this.axisYStart = 0;
		this.axisXLimit = this.board.length;
		this.axisYLimit = this.board[0].length;
	}
	
	public Integer[] findSpaceCoordinates() {
		for(Integer line = 0; line < axisXLimit; line++) {
			for(Integer column = 0; column < axisYLimit; column++) {
				if(this.board[line][column] == 0) {
					Integer[] coordinates = {line, column};
					return coordinates;
				}
			}
		}
		return null;
	}

	public void printStatus() {
		for(Integer line = 0; line < this.axisXLimit; line++) {
			System.out.print("|");
			for(Integer column = 0; column < this.axisYLimit; column++) {
				System.out.print(" "+ board[line][column]);
			}
			System.out.println(" |");
		}
	}
	
	public Integer[][] getStateOfBoard() { return this.board; }
	
	public Integer getAxisYLimit() { return axisYLimit; }
	
	public Integer getAxisXLimit() { return axisXLimit; }

	public Integer getAxisYStart() { return axisYStart; }
	
	public Integer getAxisXStart() { return axisXStart; }
	
	public void setAxisYLimit(Integer axisYLimit) { this.axisYLimit = axisYLimit; }

	public void setAxisXLimit(Integer axisXLimit) { this.axisXLimit = axisXLimit; }

	public void setAxisYStart(Integer axisYStart) { this.axisYStart = axisYStart; }

	public void setAxisXStart(Integer axisXStart) { this.axisXStart = axisXStart; }

	public void setBoard(Integer[][] board) { this.board = board; }
}
