import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ScenarioTest {
	/*
	 * Scenario 0: No interactions
	 * Given a game of life
	 * When there are no live cells
	 * Then on the next step there are still no live cells
	 */

	@Test
	public void scenario0() {
		int[][] grid = {
				{0,0,0},
				{0,0,0},
				{0,0,0}
		};
		int[][] outcome = {{0,0,0},{0,0,0},{0,0,0}};
		Rules r = new Rules();
		State state = r.nextGeneration(new State(grid));
		Assert.assertArrayEquals(outcome, state.getGrid());
		
	}
	
	/*
	 * Scenario 1: Underpopulation
	 * Given a game of life
	 * When a live cell has fewer than two neighbours
	 * Then this cell dies
	 */
	
	@Test
	public void scenario1() {
		int[][] grid = {
				{0,0,0},
				{0,1,1},
				{0,0,0}
		};
		int[][] outcome = {{0,0,0},{0,0,0},{0,0,0}};
		Rules r = new Rules();
		State state = r.nextGeneration(new State(grid));
		Assert.assertArrayEquals(outcome, state.getGrid());
		
	}
	
	/*
	 * Scenario 2: Overcrowding
	 * Given a game of life
	 * When a live cell has more than three neighbours
	 * Then this cell dies
	 */
	
	@Test
	public void scenario2() {
		int[][] grid = {
				{0,1,1},
				{1,0,1},
				{0,1,1}
		};
		int[][] outcome = {{0,1,1},{1,0,0},{0,1,1}};
		Rules r = new Rules();
		State state = r.nextGeneration(new State(grid));
		Assert.assertArrayEquals(outcome, state.getGrid());
		
	}
	
	/*
	 * Scenario 3: Survival
	 * Given a game of life
	 * When a live cell has two or three neighbours
	 * Then this cell stays alive
	 */
	
	@Test
	public void scenario3() {
		int[][] grid = {
				{0,1,1},
				{0,1,1},
				{0,0,0}
		};
		int[][] outcome = {{0,1,1},{0,1,1},{0,0,0}};
		Rules r = new Rules();
		State state = r.nextGeneration(new State(grid));
		Assert.assertArrayEquals(outcome, state.getGrid());
		
	}
	
	/*
	 * Scenario 4: Creation of Life
	 * Given a game of life
	 * When an empty position has exactly three neighbouring cells
	 * Then a cell is created in this position
	 */
	
	@Test
	public void scenario4() {
		int[][] grid = {
				{0,0,1},
				{0,1,1},
				{0,0,0}
		};
		int[][] outcome = {{0,1,1},{0,1,1},{0,0,0}};
		Rules r = new Rules();
		State state = r.nextGeneration(new State(grid));
		Assert.assertArrayEquals(outcome, state.getGrid());
		
	}
	
	/*
	 * Scenario 5: Grid with no live cells
	 * Given a game of life with the initial state containing no live cells
	 * When the game evolves one turn
	 * Then the next state also contains no live cells
	 */
	
	@Test
	public void scenario5() {
		//Scenario 5 is the same as scenario 0
		scenario0();
		
	}
	
	//Scenario 6, one evolution
	
	@Test
	public void scenario6_oneTurn() {
		int[][] grid = {
				{0,0,0},
				{1,1,1},
				{0,0,0}
		};
		int [][] outcome = {{0,1,0},{0,1,0},{0,1,0}};
		Rules r = new Rules();
		State state = r.nextGeneration(new State(grid));
		Assert.assertArrayEquals(outcome, state.getGrid());
		
	}
	
	// Scenario 6, two evolutions
	
	@Test
	public void scenario6_twoTurns() {
		int[][] grid = {
				{0,0,0},
				{1,1,1},
				{0,0,0}
		};
		int [][] outcome = {{0,0,0},{1,1,1},{0,0,0}};
		Rules r = new Rules();
		State currentState = new State(grid);
		int[][] originalGrid = currentState.getGrid();
		for(int i = 0; i<2; i++) {
			State newState = r.nextGeneration(currentState);
			currentState = newState;
		}
		Assert.assertArrayEquals(outcome, originalGrid);
		
	}

}
