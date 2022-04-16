package dsalevel1.dynamicprogramming;

import java.util.*;

public class MinCostInMazeTraversal {

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
    	
    	//int ans = rec(0, 0, n, m, grid);
    	
    	//int memo[][] = new int[n][m];
    	//int ans = rec_memo(0, 0, n, m, grid, memo);
    	
    	int ans = rec_tab(0, 0, n, m, grid);
    	
    	System.out.println(ans);    	
    }
    
    //Tabulation
    public static int rec_tab(int i, int j, int n, int m, int[][] grid) {
    	
    	int[][] dp = new int[n][m];
    	
    	for (i = n-1; i >= 0; i--) {
    		for (j = m-1; j >= 0; j--) {
    			
    			if (i == n-1 && j == m-1) {
    				dp[i][j] = grid[i][j];
    				continue;
    			}
    			
    			int ans = (int)(1e8);
    			
    			//stading at i and j, check for (i + 1, j)
    			if (i + 1 < n) {
    				ans = Math.min(ans, dp[i+1][j]);
    			}
    			
    			//stading at i and j, check for (i, j + 1)
    			if (j + 1 < m) {
    				ans = Math.min(ans, dp[i][j+1]);
    			}
    			
    			//so at i and j,value is min of next two indexes + current grid value
    			dp[i][j] = ans + grid[i][j];
    		}
    	}
    	
    	return dp[0][0];
    }
    
    //Memoization
    public static int rec_memo(int i, int j, int n, int m, int[][] grid, int[][] memo) {
    	
    	if (i == n-1 && j == m-1) {
    		return memo[i][j] = grid[i][j];
    	}
    	
    	if (memo[i][j] != 0) return memo[i][j];
    	
    	int ans = (int)(1e8);
    	
    	if (i + 1 < n) {
    		ans = Math.min(ans, rec_memo(i + 1, j, n, m, grid, memo));
    	}
    	
    	if (j + 1 < m) {
    		ans = Math.min(ans, rec_memo(i, j + 1, n, m, grid, memo));
    	}
    	
    	return memo[i][j] = ans + grid[i][j];    	
    }
    
    //Recursion
    public static int rec(int i, int j, int n, int m, int[][] grid) {
    	
    	if (i == n-1 && j == m-1) {
    		return grid[i][j];
    	}
    	
    	int ans = (int)(1e8);
    	//move vertically down
    	if (i + 1 < n) {
    		ans = Math.min(ans, rec(i + 1, j, n, m, grid));
    	}
    	
    	//mpve horizontally right
    	if (j + 1 < m) {
    		ans = Math.min(ans, rec(i, j + 1, n, m, grid));
    	}
    	
    	return ans + grid[i][j];
    }

}