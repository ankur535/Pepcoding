package dsalevel1.dynamicprogramming;

import java.util.*;

public class BuyAndSellStocksKTransactionsAllowed {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = in.nextInt();
		}

		int K = in.nextInt();
		in.close();

		// int maxProfit = Dp2DArray(n, prices, K);
		
		// int maxProfit = Dp2DArrayOptimized(n, prices, K);

		int maxProfit = Dp3DArray(n, prices, K);

		System.out.println(maxProfit);
	}

	private static int Dp3DArray(int n, int[] prices, int K) {

		int[][][] dp = new int[n][K + 1][2];

		for (int i = 0; i < n; i++) {
			for (int k = 0; k <= K; k++) {
				for (int x = 0; x < 2; x++) {

					//x == 0 denotes sell profit
					//x == 1 denotes buy profit
					//check previous questions to understand, pretty simple
					
					// base case when k == 0 (0th transaction)
					if (k == 0) {
						if (x == 0) {
							dp[i][k][x] = 0;
						} else {
							dp[i][k][x] = -(int) (1e9);
						}
					} else {
						// if i == 0, (1st day)
						if (i == 0) {
							if (x == 0) {
								dp[i][k][x] = Math.max(0, -(int) (1e9) + prices[i]);
							} else {
								dp[i][k][x] = Math.max(-(int) (1e9), 0 - prices[i]);
							}
						} else {
							// else x mathematically formula
							if (x == 0) {
								dp[i][k][x] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
							} else {
								dp[i][k][x] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
							}
						}
					}
				}
			}
		}

		return dp[n - 1][K][0];
	}

	@SuppressWarnings("unused")
	private static int Dp2DArrayOptimized(int n, int[] arr, int k) {

		int[][] dp = new int[k + 1][n];

		for (int t = 1; t <= k; t++) {

			// max till now for t-1 transaction for d-1 days
			int maxofAbove = Integer.MIN_VALUE;

			for (int d = 1; d < n; d++) {

				// updating with max including previous day
				maxofAbove = Math.max(maxofAbove, dp[t - 1][d - 1] - arr[d - 1]);

				// max will be from previous day for t transactions or (current day + maxofAbove)
				int max = Math.max(dp[t][d - 1], maxofAbove + arr[d]);

				dp[t][d] = max;

			}
		}

		return dp[k][n - 1];
	}

	@SuppressWarnings("unused")
	private static int Dp2DArray(int n, int[] arr, int k) {

		int[][] dp = new int[k + 1][n];

		for (int t = 1; t <= k; t++) {
			for (int d = 1; d < n; d++) {

				int max = dp[t][d - 1];

				for (int pd = 0; pd < d; pd++) {

					max = Math.max(max, arr[d] - arr[pd] + dp[t - 1][pd]);
				}

				dp[t][d] = max;
			}
		}

		return dp[k][n - 1];
	}

}