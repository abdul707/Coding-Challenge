
public class Rules {

	public State nextGeneration(State currentState) {
		//A new grid is initialised to hold state of the next evolution
		int newGrid[][] = new int[currentState.getRow()][currentState.getCol()];
		for(int i = 0; i<currentState.getRow(); i++) {
			for(int j = 0; j<currentState.getCol(); j++) {
				int aliveNeighbours = count(currentState, i,j);
				
				// Cell dies of loneliness if it's neighbours are less then 2 or greater than 3
            	if((currentState.isAlive(i,j)) && (aliveNeighbours<2 || aliveNeighbours>3) )
                	newGrid[i][j] = 0;
            	//A new cell is born if there is a dead cell in that pos and there's 3 alive ones surrounding it
            	else if ((!currentState.isAlive(i,j)) && (aliveNeighbours == 3))
            		newGrid [i][j] = 1;
            	
            	// Otherwise remains the same
            	else
            		newGrid[i][j] = currentState.getGrid()[i][j];
			}
		}
		//Replace the old grid with the new grid
		currentState.setGrid(newGrid);
		return currentState;
	}
	//Counting the number of alive neighbours of the current cell
	private int count(State currentState, int row, int col) {
		int count = 0;
		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				//Exception handling is used to handle errors caused by cells on the edges, as they don't have a neighbourhood of 8
				try {
					//Counting the number of live neighbours of the current cell
					count +=currentState.getGrid()[row+i][col+j];
				}
				catch(ArrayIndexOutOfBoundsException e) {
					
				}
			}
		}
		// remove the current cell from the count
		count -=currentState.getGrid()[row][col];
		return count;
	}
	
	
}
