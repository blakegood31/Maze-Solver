import java.util.*;

public class Maze {
	/**
	 * This is a class used to represent each maze we try to solve as an object.
	 * The class holds information about the maze and related functions,
	 * including the function to solve the maze
	 */
	private int row; 
	private int col;
	private Point start;
	private Point end;
	private char[][] maze;
	private boolean solutionExists;
	
	public Maze(int r, int c) {
		row = r;
		col = c;
		maze = new char[row + 2][col + 2];
	}
	
	public Maze(Maze m) {
		row = m.row;
		col = m.col;
		maze = new char[row+2][col+2];
		for(int r = 0; r<row; r++) {
			for(int c = 0; c<col; c++) {
				maze[r][c] = m.maze[r][c];
			}
		}
	}
	
	public void setSolutionExists(boolean ans) {
		//Set whether or not a solution to the maze exists
		//Input: boolean set True if a solution exists, else false
		solutionExists = ans;
	}
	
	public boolean getSolutionExists() {
		//Return whether or not a solution to the maze exists
		return solutionExists;
		
	}
	
	public void initialize(Maze m) {
		//Initialize an empty maze
		for(int r = 0; r<m.maze.length; r++) {
			for(int c = 0; c<m.maze[0].length; c++) {
				maze[r][c] = ' ';
			}
		}
	}
	
	public void read(ArrayList<String> data) {
		//Read in the data for a maze 
		// sets maze dimensions
		row = Integer.parseInt(data.get(0)) + 2;
		col = Integer.parseInt(data.get(1)) + 2;
		
		// gets start and end points
		start = new Point(Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)));
		end = new Point(Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)));
		int rowIndex = 6;
		
		// creates maze
		for(int r = 0; r < maze.length; r++) {
			for(int c = 0; c < maze[0].length; c++) {
				if(r == 0 | r == row-1 | c == 0 | c == col-1) {
					maze[r][c] = '*';
				}
				else {
					maze[r][c] = data.get(rowIndex).charAt(c-1);
				}
			}
			if(r!=0) {
				rowIndex++;
			}
		}
	}
	
	public void print() {
		//Prints out the maze
		for(int r = 0; r<row; r++) {
			for(int c = 0; c<col; c++) {
				System.out.print(maze[r][c]);
			}
			System.out.println();
		}
	}
	
	public void printall() {
		//Print out all data related to the maze 
		System.out.println("Rows: " + row);
		System.out.println("Cols: " + col);
		System.out.println("Start: " + start.getX() + start.getY());
		System.out.println("End: " + end.getX() + end.getY());
		for(int r = 0; r<row; r++) {
			for(int c = 0; c<col; c++) {
				System.out.print(maze[r][c]);
			}
			System.out.println();
		}
	}
	
	public Point getStart() {
		//Get starting point for maze
		return start;
	}
	
	public Point getEnd() {
		//Get ending point for maze 
		return end;
	}
	
	public Point getCurrent() {
		//Get current position 
		Point c = new Point(start);
		return c;
	}
	
	public boolean findPath(Maze m, Point s, Point e, Point c, ArrayList<Point> path, int index) {
		//Finds path to solve the maze 
		//Input: The maze to be solved, starting point 's', end point 'e', current point 'c', 
		//ArrayList representing the current path, and current index
		//
		//Output: boolean representing whether or not the maze was solved 
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		boolean done = false;
		
		if(c.isEqual(e)) {
			maze[c.getX()][c.getY()] = alphabet.charAt(index%26);
			return true;
		}
		// checks down
		if(m.maze[c.getX() + 1][c.getY()] == '.' && c.moves.indexOf("down") < 0) {
			m.maze[c.getX()][c.getY()] = alphabet.charAt(index%26);
			path.add(c);
			path.get(path.size()-1).addMove("down");
			Point next = new Point(c.getX() + 1, c.getY());
			done = findPath(m, s, e, next, path, index+1);
		}
		// checks right
		else if(m.maze[c.getX()][c.getY()+1] == '.' && c.moves.indexOf("right") < 0) {
			m.maze[c.getX()][c.getY()] = alphabet.charAt(index%26);
			path.add(c);
			path.get(path.size()-1).addMove("right");
			Point next = new Point(c.getX(), c.getY() + 1);
			done = findPath(m, s, e, next, path, index+1);
		}
		// checks up
		else if(m.maze[c.getX() - 1][c.getY()] == '.' && c.moves.indexOf("up") < 0) {
			m.maze[c.getX()][c.getY()] = alphabet.charAt(index%26);
			path.add(c);
			path.get(path.size()-1).addMove("up");
			Point next = new Point(c.getX() - 1, c.getY());
			done = findPath(m, s, e, next, path, index+1);
		}
		// checks left
		else if(m.maze[c.getX()][c.getY()-1] == '.' && c.moves.indexOf("left") < 0) {
			m.maze[c.getX()][c.getY()] = alphabet.charAt(index%26);
			path.add(c);
			path.get(path.size()-1).addMove("left");
			Point next = new Point(c.getX(), c.getY() - 1);
			done = findPath(m, s, e, next, path, index+1);
		}
		else {
			// backtracking element. returns to previous point and tries remaining moves if no moves are valid at current point 
			if(!c.isEqual(s)) {
				m.maze[path.get(path.size()-1).getX()][path.get(path.size()-1).getY()] = '.';
				Point next = new Point(path.get(path.size()-1));
				path.remove(path.size()-1);
				done = findPath(m, s, e, next, path, index-1);
			}
			else {
				return false;
			}
		}
		return done;	
	}
}
