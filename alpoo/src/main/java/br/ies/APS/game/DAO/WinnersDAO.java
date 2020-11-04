package br.ies.APS.game.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ies.APS.game.interfaces.DAO;

public class WinnersDAO implements DAO {

	@Override
	public void insert(Object object) {
		int id = PlayerDAO.getPlayerID((String) object);
		String insert = "INSERT INTO WINNERS (cd_player) VALUES ("+ id +");";
		ConnectionDatabase connection = new ConnectionDatabase();
		connection.executeDML(insert);
	}

	@Override
	public void delete(Object object) {
		int id = PlayerDAO.getPlayerID((String) object);
		String delete = "DELETE FROM WINNERS WHERE cd_player = "+ id +";";
		ConnectionDatabase connection = new ConnectionDatabase();
		connection.executeDML(delete);
	}

	@Override
	public void update(Object object) { }

	@Override
	public Object get(Object object) {
		String select = "SELECT (P.name) FROM PLAYER P JOIN WINNERS W ON P.id = W.cd_player;";
		ConnectionDatabase connection = new ConnectionDatabase();
		ResultSet resultSet = connection.consult(select);
		ArrayList<String> winners = new ArrayList<String>();
		
		try {
			if(resultSet.next()) {
				winners.add(resultSet.getString("name"));
			}
			
			return winners;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
