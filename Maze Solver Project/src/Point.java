import java.io.*;
import java.util.*;

public class Point {
	private int xPos;
	private int yPos;
	public ArrayList<String> moves;
	
	public Point(int x, int y) {
		/**
		 * This is a class for all of the different points in the maze 
		 */
		xPos = x;
		yPos = y;
		moves = new ArrayList<String>();
		moves.add("");
	}
	public Point(Point p) {
		xPos = p.xPos;
		yPos = p.yPos;
		moves = new ArrayList<String>();
		moves.add("");
		for(int i = 0; i<p.moves.size(); i++) {
			moves.add(p.moves.get(i));
		}
	}
	public int getX() {
		//Get X coordinate of a point
		return xPos;
	}
	public int getY() {
		//Get Y coordinate of a point 
		return yPos;
	}
	public void setX(int x) {
		//Set X coordinate of a point 
		xPos = x;
	}
	public void setY(int y) {
		//Set Y coordinate of a point
		yPos = y;
	}
	
	public boolean isEqual(Point p) {
		//Check if two points are equal 
		return (this.xPos == p.xPos) && (this.yPos == p.yPos);
	}
	
	public Point read(int x, int y) {
		//Read in coordinates to create a new point
		Point p = new Point(x,y);
		return p;
	}
	
	public void print(Point p) {
		//Print out the coordinates of a point
		System.out.println("(" + p.xPos + "," + p.yPos + ")");
	}
	
	public void addMove(String s) {
		//Add a move to all of the moves taken so far 
		moves.add(s);
	}
}
