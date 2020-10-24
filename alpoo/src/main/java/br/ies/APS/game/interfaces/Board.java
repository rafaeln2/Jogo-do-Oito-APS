package br.ies.APS.game.interfaces;

public interface Board {
	public Integer[] findSpaceCoordinates();
	public void printStatus();
	
	public Integer[][] getStateOfBoard();
	public Integer getAxisYLimit();
	public Integer getAxisXLimit();
	public Integer getAxisYStart();
	public Integer getAxisXStart();
	
	public void setAxisYLimit(Integer axisYLimit);
	public void setAxisXLimit(Integer axisXLimit);
	public void setAxisYStart(Integer axisYStart);
	public void setAxisXStart(Integer axisXStart);
	public void setBoard(Integer[][] board);
}
