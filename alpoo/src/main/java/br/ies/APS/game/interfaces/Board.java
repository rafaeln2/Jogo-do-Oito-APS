package br.ies.APS.game.interfaces;

import br.ies.APS.game.models.BoardSize;
import br.ies.APS.game.models.Player;

public interface Board {
	public Integer[] findSpaceCoordinates();
	public void printStatus();
	public BoardSize getPropertiesOfBoard();
	public Integer[][] getStateOfBoard();
	public void setBoard(Integer[][] board);
	public Player getPlayer();
	public void setPlayer(Player player);
	public void setViewer(Observable viewer);
}
