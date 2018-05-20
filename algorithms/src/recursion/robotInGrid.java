package recursion;

import java.util.ArrayList;
import java.util.HashSet;

class Point{
	
	int row, col;
	public Point(int row, int col){
		this.row = row;
		this.col = col;
		
	}
	
}

public class robotInGrid {

	public static void main(String arg[]){
		
		boolean[][] maze = {{true, false, false},
				             {true, false, true},
				             {true, false, true},
				             {true, true, true},
				             {false, true, true},
				             {true, true, true},
				             {false, true, false},
				             {false, true, true}};
		
		robotInGrid rg = new robotInGrid();
		rg.getPath(maze);
		for(Point point : rg.getPath(maze)){
			
			System.out.println(point.row + "  " +point.col);
			
		}
		
	}
	
	ArrayList<Point> getPath(boolean[][] maze){
		
		if(maze == null || maze.length == 0) return null;
		
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		
		if(getPath(maze, maze.length -1, maze[0].length -1, path, failedPoints)){
			return path;
		}
		return null;
	}
	
	boolean getPath(boolean[][] maze ,int row, int col, ArrayList<Point> path, HashSet failedPoints){
		
		if(row < 0 || col < 0 || !maze[row][col]){
			return false;
		}
		
		Point p = new Point(row, col);
		if(failedPoints.contains(p)){
			return false;
		}
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		if(isAtOrigin || getPath(maze, row, col -1, path, failedPoints) || getPath(maze, row -1, col, path, failedPoints)){
			path.add(p);
			return true;
			
		}
		failedPoints.add(p);
		return false;
		
	}
	
}
