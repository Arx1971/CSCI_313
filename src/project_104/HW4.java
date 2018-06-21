package project_104;
import java.util.*;

public class HW4 {
	// Returns true if it is possible to solve the maze,
	// starting in the top-left and ending in the bottom-right.
	public static boolean winnable(int maze[][]) {
		boolean marked[][] = new boolean[maze.length][maze[0].length];
		if (winnable(maze, 0, 0, marked)) {
			change(maze, marked);
			return true;
		}
		return false;
	}

	private static void change(int maze[][], boolean marked[][]) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (marked[i][j] == true) {
					maze[i][j] = 2;
				}
			}
		}
	}

	// Returns true if it is possible to solve the maze,
	// starting in the location maze[startRow][startCol] and ending in the
	// bottom-right.
	// If the maze is winnable, this method modifies the maze array by filling in
	// the winning path with 2s.
	// Otherwise, the maze is not modified.

	private static boolean isValid(int[][] maze, int startRow, int startCol) {

		if (startRow >= 0 && startRow < maze.length && startCol >= 0 && startCol < maze[0].length
				&& maze[startRow][startCol] == 0) {
			return true;
		}
		return false;
	}

	public static boolean winnable(int maze[][], int startRow, int startCol, boolean[][] marked) {
		int numRows = maze.length, numCols = maze[0].length;

		// If you already won, fill in the entry with 2 and return true.
		// Mark the current location as visited.
		// Call winnable recursively on each adjacent location that hasn't been visited
		// yet.
		// (do not visit invalid locations, i.e. locations that contain walls or
		// locations outside the maze)
		// If you can win from any adjacent location, fill in the entry with 2 and
		// return true.
		// Otherwise return false.

		if (startRow == numRows - 1 && startCol == numCols - 1) {
			marked[startRow][startCol] = true;
			return marked[startRow][startCol];
		}

		if (isValid(maze, startRow, startCol) && !marked[startRow][startCol]) {
			marked[startRow][startCol] = true;
			if (winnable(maze, startRow + 1, startCol, marked))
				return true;
			if (winnable(maze, startRow, startCol + 1, marked))
				return true;
			if (winnable(maze, startRow - 1, startCol, marked))
				return true;
			if (winnable(maze, startRow, startCol - 1, marked))
				return true;

			return false;
		}

		return false;
	}

	public static void print(int maze[][]) {
		for (int[] row : maze)
			System.out.println(Arrays.toString(row));
	}

	public static void main(String[] args) {
		int[][] maze1 = { { 0, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 1, 1 }, { 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		int[][] maze2 = { { 0, 0, 0, 0, 1 }, { 0, 1, 0, 1, 1 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 0 },
				{ 1, 0, 1, 0, 0 } };

		int[][] maze3 = { { 0, 0, 0, 0, 1 }, { 0, 1, 1, 0, 1 }, { 0, 1, 1, 0, 1 }, { 0, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 0 } };

		int[][] maze4 = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 1, 0 } };

		int[][] maze5 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		// For each maze, call the winnable method, then print the maze.
		// Winnable mazes should have their winning paths filled in with 2s.

		System.out.println("maze1: " + winnable(maze1)); // true
		print(maze1);

		System.out.println("\nmaze2: " + winnable(maze2)); // false
		print(maze2);

		System.out.println("\nmaze3: " + winnable(maze3)); // true
		print(maze3);

		System.out.println("\nmaze4: " + winnable(maze4)); // false
		print(maze4);

		System.out.println("\nmaze5: " + winnable(maze5)); // true
		print(maze5);
	}
}