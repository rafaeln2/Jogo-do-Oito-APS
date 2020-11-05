package br.ies.APS.game.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ies.APS.game.GameBoard;
import br.ies.APS.game.interfaces.DAO;

public class PlaysDAO implements DAO {

	@Override
	public void insert(Object object) {
		GameBoard gameBoard = (GameBoard) object;
		int id = PlayerDAO.getPlayerID(gameBoard.getPlayer().getName());
		String insert = "INSERT INTO PLAYS (cd_player, cell_1, cell_2, cell_3, cell_4, cell_5, cell_6, cell_7, cell_8, cell_9) VALUES ("
						+ id +", " 
						+ gameBoard.getStateOfBoard()[0][0] +", "
						+ gameBoard.getStateOfBoard()[0][1] +", "
						+ gameBoard.getStateOfBoard()[0][2] +", "
						+ gameBoard.getStateOfBoard()[1][0] +", "
						+ gameBoard.getStateOfBoard()[1][1] +", "
						+ gameBoard.getStateOfBoard()[1][2] +", "
						+ gameBoard.getStateOfBoard()[2][0] +", "
						+ gameBoard.getStateOfBoard()[2][1] +", "
						+ gameBoard.getStateOfBoard()[2][2] +" );";
		
		ConnectionDatabase connection = new ConnectionDatabase();
		connection.executeDML(insert);
	}

	@Override
	public void delete(Object object) {
		GameBoard gameBoard = (GameBoard) object;
		int id = PlayerDAO.getPlayerID(gameBoard.getPlayer().getName());
		String delete = "DELETE FROM PLAYS WHERE cd_player = '"+ id +"';";
		ConnectionDatabase connection = new ConnectionDatabase();
		connection.executeDML(delete);
	}

	@Override
	public void update(Object object) {
		GameBoard gameBoard = (GameBoard) object;
		int id = PlayerDAO.getPlayerID(gameBoard.getPlayer().getName());
		String update = "UPDATE PLAYS SET "+
						"cell_1 = "+ gameBoard.getStateOfBoard()[0][0] +", " +
						"cell_2 = "+ gameBoard.getStateOfBoard()[0][1] +", " + 
						"cell_3 = "+ gameBoard.getStateOfBoard()[0][2] +", " +
						"cell_4 = "+ gameBoard.getStateOfBoard()[1][0] +", " +
						"cell_5 = "+ gameBoard.getStateOfBoard()[1][1] +", " + 
						"cell_6 = "+ gameBoard.getStateOfBoard()[1][2] +", " +
						"cell_7 = "+ gameBoard.getStateOfBoard()[2][0] +", " + 
						"cell_8 = "+ gameBoard.getStateOfBoard()[2][1] +", " + 
						"cell_9 = "+ gameBoard.getStateOfBoard()[2][2] +
						"WHERE cd_player = "+ id +";";
						 
		ConnectionDatabase connection = new ConnectionDatabase();
		connection.executeDML(update);
	}

	@Override
	public Object get(Object object) {
		int id = PlayerDAO.getPlayerID((String) object);
		String select = "SELECT * FROM PLAYS WHERE cd_player = "+ id +";";
		ConnectionDatabase connection = new ConnectionDatabase();
		ResultSet resultSet = connection.consult(select);
		
		try {
			if(resultSet.next()) {
				
				return new Integer[][] {
					{ resultSet.getInt("cell_1"), resultSet.getInt("cell_2"), resultSet.getInt("cell_3") },
					{ resultSet.getInt("cell_4"), resultSet.getInt("cell_5"), resultSet.getInt("cell_6") },
					{ resultSet.getInt("cell_7"), resultSet.getInt("cell_8"), resultSet.getInt("cell_9") }
				};
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public Integer getTotalPlays(String playerName) {
		int id = PlayerDAO.getPlayerID(playerName);
		String select = "SELECT COUNT(cd_player) FROM PLAYS WHERE cd_player = "+ id +";";
		ConnectionDatabase connection = new ConnectionDatabase();
		ResultSet resultSet = connection.consult(select);
		
		try {
			if(resultSet.next()) {
				
				return resultSet.getInt("count");
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
