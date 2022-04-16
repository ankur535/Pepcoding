package dsalevel1.dynamicprogramming;

import java.util.*;

public class Goldmine {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		int[][] grid = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		in.close();

		int max_gold = 0;

		//int[][] memo = new int[n][m];

		//for (int i = 0; i < n; i++) {
			//max_gold = Math.max(max_gold, rec(i, 0, n, m, grid));

			//max_gold = Math.max(max_gold, rec_memo(i, 0, n, m, grid, memo));
		//}
		
		max_gold = rec_tab(n, m, grid);

		System.out.println(max_gold);
	}

	//Tabulation
	public static int rec_tab(int n, int m, int[][] grid) {
		
		int[][] dp = new int[n][m];
		
		for (int j = m-1; j >= 0; j--) {
			for (int i = 0; i < n; i++) {
				
				//fill last column same as grid
				if (j == m-1) {
					dp[i][j] = grid[i][j];
					continue;
				} else if (i == 0 && i + 1 < n) {
					//can go right down, right straight
					dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1]) + grid[i][j];
				} else if (i == n-1) {
					//can go right up, right straight
					dp[i][j] = Math.max(dp[i-1][j+1], dp[i][j+1]) + grid[i][j];
				} else {
					//can go right up, right straight and right down
					dp[i][j] = Math.max(Math.max(dp[i-1][j+1], dp[i][j+1]), dp[i+1][j+1]) + grid[i][j];
				}
				
				/*
				 * Or this can be done, this is better than above as can handle many cases
				 * above code will fail if row is only 1
				 * 
				 * int ans = 0;
				 * 
				 * if (i-1 >= 0) { ans = Math.max(ans, dp[i-1][j+1]); }
				 * 
				 * ans = Math.max(ans, dp[i][j+1]);
				 * 
				 * if (i+1 < n) { ans = Math.max(ans, dp[i+1][j+1]); }
				 * 
				 * dp[i][j] = ans + grid[i][j];
				 */
			}
		}
		
		//find maximum value from 1st column
		int max_gold = 0;
		
		for (int i = 0; i < n; i++) {
			max_gold = Math.max(max_gold, dp[i][0]);
		}
		
		return max_gold;
	}
	
	//Memoization
	public static int rec_memo(int i, int j, int n, int m, int[][] grid, int[][] memo) {
    	
    	if (j == m-1) {
    		return memo[i][j] = grid[i][j];
    	}
    	
    	if (memo[i][j] != 0) return memo[i][j];
    	
    	int ans = 0;
    	
    	if (i-1 >= 0) {
    		ans = Math.max(ans, rec_memo(i - 1, j + 1, n, m, grid, memo));
    	}
    	
    	ans = Math.max(ans, rec_memo(i, j + 1, n, m, grid, memo));
    	
    	if (i + 1 < n) {
    		ans = Math.max(ans, rec_memo(i + 1, j + 1, n, m, grid, memo));
    	}
    	
    	return memo[i][j] = ans + grid[i][j];    	
    }

	// Recursion
	public static int rec(int i, int j, int n, int m, int[][] grid) {

		if (j == m - 1) {
			return grid[i][j];
		}

		int ans = 0;

		// check only for i as j is already in range due to base case of j
		if (i - 1 >= 0) {
			ans = Math.max(ans, rec(i - 1, j + 1, n, m, grid));
		}

		ans = Math.max(ans, rec(i, j + 1, n, m, grid));

		if (i + 1 < n) {
			ans = Math.max(ans, rec(i + 1, j + 1, n, m, grid));
		}

		return ans + grid[i][j];
	}

}