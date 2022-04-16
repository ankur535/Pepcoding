package dsalevel1.dynamicprogramming;

import java.util.*;

public class FibonacciDP {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		// int ans = fibo_rec(n);

		int[] qb = new int[n + 1];
		int ans = fibo_memo(n, qb);
		
		//int ans = fibo_tab(n);
		System.out.println(ans);
	}

	// DP memoization
	public static int fibo_memo(int n, int[] qb) {

		if (n <= 1) {
			qb[n] = n; // no need to store qb here
			return n;
		}

		if (qb[n] != 0)
			return qb[n];

		int ans = fibo_memo(n - 1, qb) + fibo_memo(n - 2, qb);
		// storing ans before returning
		qb[n] = ans;
		return ans;
	}
	
	//dp tabulation, iterative code
	public static int fibo_tab(int n) {
		
		int[] dp = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			if (i <= 1) {
				dp[i] = i;
				continue;
			}
			
			int ans = dp[i-1] + dp[i-2];
			dp[i] = ans;
		}
		
		return dp[n];
	}

	// Recursive fibonacci, which will take lots of time and space
	public static int fibo_rec(int n) {

		if (n <= 1) return n;

		return fibo_rec(n - 1) + fibo_rec(n - 2);
	}

}