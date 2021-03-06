package br.ies.APS.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.ies.APS.game.GameBoard;
import br.ies.APS.game.Movement;
import br.ies.APS.game.Viewer;
import br.ies.APS.game.models.BoardSize;
import br.ies.APS.game.models.Player;

class EightPuzzleTests {
	
	@Test
	void testIfMoveUPItsCorrectlyWorks() throws Exception {
		Viewer viewer = new Viewer();
		Player vitor = new Player("Vitor");
		GameBoard game = new GameBoard(BoardSize.MEDIUM);
		game.setViewer(viewer);
		game.setPlayer(vitor);
		Movement movement = new Movement(game);
		
		Integer[][] tableMovedUP = new Integer[][] { {1, 2, 3}, {4, 5, 0}, {7, 8, 6} };
		
		movement.moveUP();
		
		assertEquals(game.getStateOfBoard()[1][2], tableMovedUP[1][2]);
	}
	
	@Test
	void testIfMoveDownItsCorrectlyWorks() throws Exception {
		Viewer viewer = new Viewer();
		Player vitor = new Player("Vitor");
		GameBoard game = new GameBoard(BoardSize.MEDIUM);
		game.setViewer(viewer);
		game.setPlayer(vitor);
		Movement movement = new Movement(game);
		
		Integer[][] tableMovedDown = new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
		
		movement.moveDown();
		
		assertEquals(game.getStateOfBoard()[2][2], tableMovedDown[2][2]);
	}
	
	@Test
	void testIfMoveLeftItsCorrectlyWorks() throws Exception {
		Viewer viewer = new Viewer();
		Player vitor = new Player("Vitor");
		GameBoard game = new GameBoard(BoardSize.MEDIUM);
		game.setViewer(viewer);
		game.setPlayer(vitor);
		Movement movement = new Movement(game);
		
		Integer[][] tableMovedLeft = new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 0, 8} };
		
		movement.moveLeft();
		
		assertEquals(game.getStateOfBoard()[2][1], tableMovedLeft[2][1]);
	}
	
	@Test
	void testIfMoveRightItsCorrectlyWorks() throws Exception {
		Viewer viewer = new Viewer();
		Player vitor = new Player("Vitor");
		GameBoard game = new GameBoard(BoardSize.MEDIUM);
		game.setViewer(viewer);
		game.setPlayer(vitor);
		Movement movement = new Movement(game);
		
		Integer[][] tableMovedRight = new Integer[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
		
		movement.moveRight();
		
		assertEquals(game.getStateOfBoard()[2][2], tableMovedRight[2][2]);
	}

}
