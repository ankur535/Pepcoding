package dsalevel1.dynamicprogramming;

import java.util.*;

public class TilingWithM1Tiles {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		in.close();
		
		//int ans = rec(n, m);
		
		/*
		int[] memo = new int[n+1];
		int ans = rec_memo(n, m, memo);
		*/
		
		//int ans = rec_tab(n, m);
		
		int ans = tab2(n, m);
		
		System.out.println(ans);
	}
	
	//Tabulation with different way
	public static int tab2(int N, int m) {
		
		int[] dp = new int[N+1];
		
		for (int n = 1; n <= N; n++) {
			
			if (n == 1) {
				//if only 1 tile can be put
				dp[n] = 1;
			} else if (n < m) {
				//if n is smaller means only vertical tiles can be put
				dp[n] = 1;
			} else if (n == m) {
				//means only 2 ways, complete horizontal or complete vertical
				dp[n] = 2;
			} else {
				//otherwise find from n-1 and n-m
				dp[n] = dp[n-1] + dp[n-m];		
			}
		}
		
		return dp[N];
	}
	
	//Tabulation
	public static int rec_tab(int N, int m) {
		
		int[] dp = new int[N+1];
		dp[0] = 1;
		
		for (int n = 1; n <= N; n++) {
			
			//placinf vertical tile
			int ans = dp[n-1];
			
			//placing horizontal tile
			if (n - m >= 0) {
				ans += dp[n-m];
			}
			
			dp[n] = ans;
		}
		
		return dp[N];
	}
	
	//Memoization
	public static int rec_memo(int n, int m, int[] memo) {
		
		if (n == 0) {
			return memo[n] = 1;
		}
		
		if (memo[n] != 0) return memo[n];
		
		//placing tile vertically
		int ans = rec_memo(n-1, m, memo);
		
		if (n - m >= 0) {
			ans += rec_memo(n-m, m , memo);
		}
		
		return memo[n] = ans;		
	}
	
	//Recursion
	public static int rec(int n, int m) {
		
		if (n == 0) {
			return 1;
		}
		
		//placing tile vertically
		int ans = rec(n-1, m);
		
		if (n - m >= 0) {
			ans += rec(n-m, m);
		}
		
		return ans;
	}
}