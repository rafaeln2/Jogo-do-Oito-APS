package br.ies.APS.view;

import java.util.Arrays;

import br.ies.APS.game.models.BoardSize;

public final class VictoryCheck {
	
	public static boolean verify(Integer[][] board) {
		return Arrays.deepEquals(BoardSize.MEDIUM.getModel(), board) ? true : false;
	}
}
