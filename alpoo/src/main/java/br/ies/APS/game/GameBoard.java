package br.ies.APS.game;

import java.util.ArrayList;
import java.util.Random;

import br.ies.APS.game.interfaces.Board;
import br.ies.APS.game.interfaces.Observable;
import br.ies.APS.game.interfaces.Observer;
import br.ies.APS.game.models.BoardSize;

public class GameBoard implements Board, Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private BoardSize board;
	private Integer[][] stateOfBoard;
	private Random random;
	
	public GameBoard(BoardSize board) {
		this.board = board;
		this.stateOfBoard = board.getModel();
	}
	
	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(this.getStateOfBoard());
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
		
		this.notifyObservers();
	}
}
