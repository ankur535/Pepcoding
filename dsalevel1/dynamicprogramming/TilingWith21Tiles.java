package dsalevel1.dynamicprogramming;

import java.util.*;

public class TilingWith21Tiles {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.close();
		
		//int ans = rec(n);

		/*
		int[] memo = new int[n+1];
		int ans = rec_memo(n, memo);
		*/
		
		//int ans = rec_tab(n);
		
		int ans = tab_better(n);
		
		System.out.println(ans);
	}
	
	//Tabulation better, same as fibonacci
	public static int tab_better(int n) {
		
		if (n == 1) return 1;
		
		int a = 1;	//for n == 0 case
		int b = 1;	//for n == 1 case
		
		for (int i = 2; i <= n; i++) {
			
			//simple next value is sum of last 2 values
			int c = a + b;
			
			a = b;
			b = c;			
		}
		
		return b;		
	}
	
	//tabulation
	public static int rec_tab(int n) {
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			
			int ans = dp[i-1];
			
			//placing horizontal tile
			if (i-2 >= 0) {
				ans += dp[i-2];
			}
			
			dp[i] = ans;
		}
				
		return dp[n];
	}
	
	//memoization
	public static int rec_memo(int n, int[] memo) {
		
		if (n == 0) {
			return memo[n] = 1;
		}
		
		if (memo[n] != 0) return memo[n];
		
		//Vertical tile
		int ans = rec_memo(n-1, memo);
		
		//Horizontal tile
		if (n-2 >= 0) {
			ans += rec_memo(n-2, memo);
		}
		
		return memo[n] = ans;
	}
	
	//Recursion
	public static int rec(int n) {
		
		if (n == 0) {
			return 1;
		}
	
		//Vertical Tile
		int ans = rec(n-1);
		
		//Horizontal Tile
		if (n-2 >= 0) {
			ans += rec(n-2);
		}
		
		return ans;		
	}
}