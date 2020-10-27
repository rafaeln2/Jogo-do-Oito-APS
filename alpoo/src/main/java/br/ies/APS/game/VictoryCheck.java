package br.ies.APS.game;

import java.util.Arrays;

import br.ies.APS.game.interfaces.Observer;
import br.ies.APS.game.models.BoardSize;

public class VictoryCheck implements Observer {
	
	@Override
	public void update(Integer[][] board) {
		
		if(Arrays.deepEquals(BoardSize.MEDIUM.getModel(), board)) {
			System.out.println("Opa! Você ganhou! Parabéns!");
		} else {
			System.out.println("Ainda não...");
		}
	}
}
