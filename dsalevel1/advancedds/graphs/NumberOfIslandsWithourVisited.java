package dsalevel1.advancedds.graphs;

import java.io.*;

public class NumberOfIslandsWithourVisited {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			String parts = br.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
			}
		}

		// write your code here
		System.out.println(numIslands(arr));
	}

	public static int numIslands(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int count = 0;

		// travel over entire 2D array
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// if value is 1, call dfs
				if (grid[i][j] == 0) {
					dfs(i, j, grid);
					// dfs will travel to each connected island and connect them as 1
					count++;
				}
			}
		}

		return count;
	}

	public static void dfs(int i, int j, int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		// make value from 1 to 0 to not visit again
		grid[i][j] = 1;

		// direction array for 2D array
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		for (int[] dir : dirs) {
			// find new x and y from directions
			int x = i + dir[0];
			int y = j + dir[1];

			// if i and j in range
			// if value is 1, call dfs
			if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0) {
				dfs(x, y, grid);
			}
		}
	}

}