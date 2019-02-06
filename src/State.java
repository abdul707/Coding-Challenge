
public class State {
	//2D array used to store live & dead cells
	private int [][] grid;
	
	public State(int[][] grid) {
		this.grid = grid;
	}
	
	//Returns the grid belonging to the state
	public int[][] getGrid(){
		return grid;
	}
	
	//Used to replace old grid with new grid
	public void setGrid(int[][] newGrid) {
		this.grid = newGrid;
	}
	
	//Checks with the given coordinates if there is a live cell 
	//1 = alive, 0 = dead
	public boolean isAlive(int row, int col) {
		if(grid[row][col] == 1)
			return true;
		return false;
		
	}
	
	//Returns the number of rows in the 2D grid
	public int getRow() {
		return grid.length;
	}
	
	//Returns the number of columns in the 2D grid
	public int getCol() {
		return grid[0].length;
	}
	
	/*
	 * Method below prints the grid
	 * 0 is a dead cell and is represented by "."
	 * 1 is an alive cell and is represented by "*"
	 */
	
	public void printGrid() {
		for(int i = 0; i<this.getRow(); i++ ) {
			for(int j = 0; j<this.getCol(); j++) {
				if(this.grid[i][j] == 0) 
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
}
