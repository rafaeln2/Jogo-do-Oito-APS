package br.ies.APS.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.ies.APS.game.GameBoard;
import br.ies.APS.game.Movement;

class EightPuzzleTests {
	
	@Test
	void testIfMoveUPItsCorrectlyWorks() throws Exception {
		Movement movement = new Movement();
		GameBoard.setBoard(new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} });
		Integer[][] tableMovedUP = new Integer[][] { {1, 2, 3}, {4, 5, 0}, {7, 8, 6} };
		
		movement.moveUP();
		
		assertEquals(GameBoard.getStatus()[1][2], tableMovedUP[1][2]);
	}
	
	@Test
	void testIfMoveDownItsCorrectlyWorks() throws Exception {
		Movement movement = new Movement();
		GameBoard.setBoard(new Integer[][] { {1, 2, 3}, {4, 5, 0}, {7, 8, 6} });
		
		Integer[][] tableMovedDown = new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
		
		movement.moveDown();
		
		assertEquals(GameBoard.getStatus()[2][2], tableMovedDown[2][2]);
	}
	
	@Test
	void testIfMoveLeftItsCorrectlyWorks() throws Exception {
		Movement movement = new Movement();
		GameBoard.setBoard(new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} });
		
		Integer[][] tableMovedLeft = new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 0, 8} };
		
		movement.moveLeft();
		
		assertEquals(GameBoard.getStatus()[2][1], tableMovedLeft[2][1]);
	}
	
	@Test
	void testIfMoveRightItsCorrectlyWorks() throws Exception {
		Movement movement = new Movement();
		GameBoard.setBoard(new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 0, 8} });
		
		Integer[][] tableMovedRight = new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
		
		movement.moveRight();
		
		assertEquals(GameBoard.getStatus()[2][2], tableMovedRight[2][2]);
	}

}
