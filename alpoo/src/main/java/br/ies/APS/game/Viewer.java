package br.ies.APS.game;

import java.util.ArrayList;

import br.ies.APS.game.interfaces.Board;
import br.ies.APS.game.interfaces.Observable;
import br.ies.APS.game.interfaces.Observer;

public class Viewer implements Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private Board gameBoard;
	
	public Viewer(Board gameBoard) {
		this.gameBoard = gameBoard;
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
			observer.update(this.gameBoard.getStateOfBoard());
		}
	}
}
