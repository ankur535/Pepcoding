package dsalevel1.dynamicprogramming;

import java.util.*;

public class ClimbStairs {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		//int ans = climb_rec(n);

		//int[] qb = new int[n + 1];
		//int ans = climb_memo(n, qb);

		int ans = climb_tab(n);
		
		System.out.println(ans);
	}
	
	//Tabulation
	public static int climb_tab(int n) {
		
		int[] dp = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			
			//base case
			if (i == 0) {
				dp[i] = 1;
				continue;
			}
			
			//same as climb stairs memo			
			int ans = dp[i-1];
			
			if (i-2 >= 0) {
				ans += dp[i-2];
			}
			
			if (i-3 >= 0) {
				ans += dp[i-3];
			}
			
			//save ans for i
			dp[i] = ans;
		}
		
		//return value at n
		return dp[n];		
	}

	// Memoization
	public static int climb_memo(int n, int[] qb) {

		// base case
		if (n == 0) {
			qb[0] = 1;
			return 1;
		}

		// check if already solved
		if (qb[n] != 0)
			return qb[n];

		int ans = climb_memo(n - 1, qb);

		if (n - 2 >= 0) {
			ans += climb_memo(n - 2, qb);
		}

		if (n - 3 >= 0) {
			ans += climb_memo(n - 3, qb);
		}

		// store and return
		qb[n] = ans;
		return ans;
	}

	// Recursive call
	public static int climb_rec(int n) {

		if (n == 0)
			return 1;

		int ans = climb_rec(n - 1);

		if (n - 2 >= 0) {
			ans += climb_rec(n - 2);
		}

		if (n - 3 >= 0) {
			ans += climb_rec(n - 3);
		}

		return ans;
	}
}