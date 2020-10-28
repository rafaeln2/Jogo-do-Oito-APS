package br.ies.APS.game.models;

import br.ies.APS.game.GameBoard;

public class Player {
	String name;
	GameBoard board;
	
	public Player(String name, GameBoard board) {
		this.name = name;
		this.board = board;
	}
}
