package br.ies.APS.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.ies.APS.game.EightPuzzle;

class EightPuzzleTests {
	private EightPuzzle game;
	
	@Before
	private void setUP() {
		this.game = new EightPuzzle();
	}
	
	@Test
	void testIfMoveUPItsCorrectlyWorks() throws Exception {
		Integer[][] tableMovedUP = new Integer[][] { {1, 2, 3}, {7, 4, 0}, {8 ,5, 6} };
		game.moveUP();
		game.printStatus();
		Integer[][] result = game.getStatus();
		assert(tableMovedUP == result);
	}

}
