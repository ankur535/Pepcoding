package dsalevel2.advancedds.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RottingOranges {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		System.out.println(orangesRotting(arr));

	}

	public static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static int orangesRotting(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int freshOranges = 0;
		LinkedList<Pair> que = new LinkedList<>();

		//count freshOranges and if rotten add to queue
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					freshOranges++;
				} else if (grid[i][j] == 2) {
					//if rotten orange, insert its index in 2D array
					//Done for Leetcode: Can also convert to 1D index and put that
					que.addLast(new Pair(i, j));
					;
				}
			}
		}
		
		//if freshOranges are 0, return 0;
		if (freshOranges == 0) {
			return 0;
		}

		//2D direction array
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		int level = 0;

		while (que.size() > 0) {
			int size = que.size();

			while (size-- > 0) {

				Pair top = que.removeFirst();

				int row = top.row;
				int col = top.col;

				for (int[] dir : dirs) {
					//find new indexes
					int x = row + dir[0];
					int y = col + dir[1];

					if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
						//if orange is fresh, have value 1, make it 2
                        //so that we don't need visited array
						grid[x][y] = 2;
						freshOranges--;

						//if freshOranges reaches 0, means last level not traversed
                        //so return level + 1
						if (freshOranges == 0) {
							return level + 1;
						}
						//add new Pair(x,y)
						que.addLast(new Pair(x, y));
					}
				}
			}
			level++;
		}

		//if don't return before, means freshOranges left but couldn't reach
		return -1;
	}

}