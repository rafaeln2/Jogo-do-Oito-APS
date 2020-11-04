package br.ies.APS.game.DAO;

import br.ies.APS.game.interfaces.Board;
import br.ies.APS.game.interfaces.Observer;

public class ManageDatabase implements Observer {

	@Override
	public void update(Board board) {
		PlaysDAO plays = new PlaysDAO();
		plays.insert(board);
	}
}
