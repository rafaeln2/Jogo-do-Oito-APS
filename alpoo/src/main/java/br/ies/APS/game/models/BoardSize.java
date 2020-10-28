package br.ies.APS.game.models;

public enum BoardSize {
	MEDIUM(new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} });
	
	private Integer[][] model;
	
	BoardSize(Integer[][] model) {
		this.model = model;
	}

	public Integer[][] getModel() {
		return model;
	}
	
	public Integer getAxisXStart() {
		return 0;
	}
	
	public Integer getAxisYStart() {
		return 0;
	}
	
	public Integer getAxisXLimit() {
		return this.getModel()[0].length;
	}
	
	public Integer getAxisYLimit() {
		return this.getModel().length;
	}
}
