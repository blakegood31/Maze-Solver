import java.util.*;

public class MazeSolver {
	
	public static void main(String[] args) {
		/** 
		 * This program will take a maze and find 
		 * whether or not a solution exists, along with 
		 * the solution if it does exist
		 * 
		 * Inputs (from console): number of mazes, number of rows/columns in 
		 * each maze, starting coordinates, ending coordinates, and 
		 * the mazes themselves (.'s are valid moves, *'s are 
		 * restricted moves)
		 * 
		 * Outputs: Whether or not a solution to the maze exists,
		 * and the solution if it does exist
		 * 
		 *  To run, copy and paste contents of 'mazeTests.txt into 
		 *  the console
		 */
		
		// Reads through input and solves for each maze
		Scanner sc = new Scanner(System.in);
		int numMazes = sc.nextInt();
		int mazeIndex = 1;
		ArrayList<Maze> solvedMazes = new ArrayList<Maze>();
		//Loop to solve each maze
		for(int i = 0; i<numMazes; i++) {
			int alphabetIndex = 0;
			
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			
			//Get data on a maze (i.e. rows, cols, and maze)
			ArrayList<String> data = new ArrayList<String>();
			data.add(Integer.toString(rows));
			data.add(Integer.toString(cols));
			
			for(int j = 0; j<(rows+4); j++) {
				String add = sc.next();
				data.add(add);
			}

			//Create new maze to be solved and read in data
			Maze first = new Maze(rows, cols);
			first.read(data); 
			//Create array list to hold path to solve the maze
			ArrayList<Point> path = new ArrayList<Point>();
			boolean solved = first.findPath(first, first.getStart(), first.getEnd(), first.getCurrent(), path, alphabetIndex);
			
			//If maze is solved, add it to list of solved mazes and set its solution to true 
			if(solved == true) {
				Maze temp = new Maze(first);
				temp.setSolutionExists(true);
				solvedMazes.add(temp);
			}
			//If maze is not solved, add it to list of solved mazes and set solution to false 
			else {
				Maze temp = new Maze(first);
				temp.setSolutionExists(false);
				solvedMazes.add(temp);
			}
			data.clear();
			mazeIndex = mazeIndex+rows+6;
		}
		
		// Prints out result for each maze
		for(int i = 0; i<solvedMazes.size(); i++) {
			if(solvedMazes.get(i).getSolutionExists() == false) {
				System.out.println("Maze #" + (i+1) + ": No Solution Exists");
			}
			else {
				System.out.println("Maze #" + (i+1) + ": Solution Found");
				solvedMazes.get(i).print();
			}
			System.out.println();
		}
	}			
}
