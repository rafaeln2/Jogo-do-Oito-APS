package br.ies.APS.game.interfaces;

public interface DAO {
	public void insert(Object object);
	public void delete(Object object);
	public void update(Object object);
	public Object get(Object object);
}
