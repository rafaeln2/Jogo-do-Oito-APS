package br.ies.APS.game.interfaces;

import br.ies.APS.game.models.BoardSize;

public interface Board {
	public Integer[] findSpaceCoordinates();
	public void printStatus();
	public BoardSize getPropertiesOfBoard();
	public Integer[][] getStateOfBoard();
	public void setBoard(Integer[][] board);
}
