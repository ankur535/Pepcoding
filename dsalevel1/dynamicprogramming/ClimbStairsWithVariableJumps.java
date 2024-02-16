package dsalevel1.dynamicprogramming;

import java.util.*;

public class ClimbStairsWithVariableJumps {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		// int ans = rec(n, 0, arr);

		// int[] memo = new int[n+1];
		// Arrays.fill(memo, -1);

		// int ans = rec_memo(n, 0, arr, memo);

		int ans = rec_tab(n, arr);

		System.out.println(ans);
	}

	// Tabulation
	public static int rec_tab(int n, int[] arr) {

		int[] dp = new int[n + 1];

		dp[n] = 1;

		for (int i = n-1; i >= 0; i--) {

			int steps = arr[i];

			int sum = 0;

			for (int j = 1; j <= steps; j++) {
				if (i + j <= n) {
					sum += dp[i + j];
				} else {
					break;
				}
			}

			dp[i] = sum;
		}

		for (int i = 0; i <= n; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();

		return dp[0];
	}

	// memoization
	public static int rec_memo(int n, int src, int[] arr, int[] memo) {

		if (src == n) {
			return memo[src] = 1;
		}

		if (memo[src] != -1)
			return memo[src];

		int jumps_allowed = arr[src];

		int sum = 0;

		for (int i = 1; i <= jumps_allowed; i++) {
			if (src + i <= n) {
				sum += rec_memo(n, src + i, arr, memo);
			} else {
				break;
			}
		}

		return memo[src] = sum;
	}

	// Recursion
	public static int rec(int n, int src, int[] arr) {

		if (src == n) {
			return 1;
		}

		int jumps_allowed = arr[src];

		int sum = 0;

		// loop over the number of jumps allowed
		for (int i = 1; i <= jumps_allowed; i++) {
			if (src + i <= n) {
				sum += rec(n, src + i, arr);
			} else {
				break;
			}
		}

		return sum;
	}
}