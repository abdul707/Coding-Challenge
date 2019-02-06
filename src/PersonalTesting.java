
public class PersonalTesting {
	
	//Use this class if you want to do extra testing 
	//Use printGrid() from State class to see a visual representation of the grid
	
	public static void main(String args[]) {
		//Here i'm testing scenario 6 and providing a visual representation
		int[][] grid = {
				{0,0,0},
				{1,1,1},
				{0,0,0}
		};
		
		State s = new State(grid);
		Rules r = new Rules();
		s.printGrid();
		int grid2[][] = s.getGrid();
		for(int i = 0; i<2; i++) {
			State newState = r.nextGeneration(s);
			newState.printGrid();
			s = newState;
		}
		
	}
	
}
