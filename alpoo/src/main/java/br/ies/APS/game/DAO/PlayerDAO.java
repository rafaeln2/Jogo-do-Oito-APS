package br.ies.APS.game.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ies.APS.game.interfaces.DAO;
import br.ies.APS.game.models.Player;

public class PlayerDAO implements DAO {
	
	public static int getPlayerID(String name) {
		PlayerDAO playerDAO = new PlayerDAO();
		Player player = (Player) playerDAO.get(name);
		return player.getId();
	}
	
	@Override
	public void insert(Object object) {
		String player = (String) object;
		String insert = "INSERT INTO PLAYER (name) VALUES ('"+ player +"');";
		ConnectionDatabase connection = new ConnectionDatabase();
		connection.executeDML(insert);
	}

	@Override
	public void delete(Object object) {
		Player player = (Player) object;
		player.setId((Integer) ((Player) get(player.getName())).getId());
		String delete = "DELETE FROM PLAYER WHERE id = '"+ player.getId() +"';";
		ConnectionDatabase connection = new ConnectionDatabase();
		connection.executeDML(delete);
	}

	@Override
	public void update(Object object) {
		Player player = (Player) object;
		player.setId((Integer) ((Player) get(player.getName())).getId());
		String update = "UPDATE PLAYER SET name = '"+ player.getName() +"' WHERE id = "+ player.getId() +";";
		ConnectionDatabase connection = new ConnectionDatabase();
		connection.executeDML(update);
	}

	@Override
	public Object get(Object object) {
		String name = (String) object;
		String select = "SELECT * FROM PLAYER WHERE name = '"+ name +"';";
		ConnectionDatabase connection = new ConnectionDatabase();
		ResultSet resultSet = connection.consult(select);
		
		try {
			if(resultSet.next()) {
				Player player = new Player(resultSet.getString("name"));
				player.setId(resultSet.getInt("id"));
				
				return player;
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
