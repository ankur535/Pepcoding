package dsalevel1.dynamicprogramming;

import java.util.*;

public class CoinChangeCombination {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		int tar = in.nextInt();
		in.close();

		//to move 0 to n
		// int ans = rec(0, arr, tar);

		/*
		 	int[][] memo = new int[n + 1][tar + 1];
			for (int[] m : memo) {
				Arrays.fill(m, -1);
			}
	
			int ans = rec_memo(0, arr, tar, memo);
		*/
		
		//move from n to 0
		//int ans = rec2(n, arr, tar);
		
		/*
		 	int[][] memo = new int[n + 1][tar + 1];
			for (int[] m : memo) {
				Arrays.fill(m, -1);
			}

			int ans = rec_memo2(n, arr, tar, memo);
		 */
		
		int ans = rec_tab2(arr, tar);
		
		System.out.println(ans);
	}
	
	//Tabulation 2 from n to 0
	public static int rec_tab2(int[] arr, int Tar) {
		
		int n = arr.length;
		
		int[][] dp = new int[n+1][Tar+1];
		
		for (int idx = 0; idx <= n; idx++) {
			for (int tar = 0; tar <= Tar; tar++) {
				
				if (tar == 0) {
					dp[idx][tar] = 1;
					continue;
				}
				
				if (idx == 0) {
					dp[idx][tar] = 0;
					continue;
				}
				
				//add how many ways to get answer
				if (tar - arr[idx-1] >= 0) {
					dp[idx][tar] += dp[idx][tar - arr[idx-1]];
				}
				
				dp[idx][tar] += dp[idx-1][tar];
			}
		}
		
		return dp[n][Tar];		
	}
	
	//Memoization 2 from n to 0
	public static int rec_memo2(int idx, int[] arr, int tar, int[][] memo) {
		
		if (tar == 0) {
			return memo[idx][tar] = 1;
		}
		
		if (idx == 0) {
			return memo[idx][tar] = 0;
		}
		
		int ans = 0;
		
		//include with same idx
		if (tar - arr[idx-1] >= 0) {
			ans += rec_memo2(idx, arr, tar - arr[idx-1], memo);
		}
		
		//don't include, move to next idx with same target
		ans += rec_memo2(idx-1, arr, tar, memo);
		
		return memo[idx][tar] = ans;
	}
	
	//Recursion 2 from n to 0
	public static int rec2(int idx, int[] arr, int tar) {
		
		if (tar == 0) {
			return 1;
		}
		
		if (idx == 0) {
			return 0;
		}
		
		int ans = 0;
		
		//include with same idx
		if (tar - arr[idx-1] >= 0) {
			ans += rec2(idx, arr, tar - arr[idx-1]);
		}
		
		//don't include, move to next idx with same target
		ans += rec2(idx-1, arr, tar);
		
		return ans;
	}

	//Memoization
	public static int rec_memo(int idx, int[] arr, int tar, int[][] memo) {

		if (tar == 0) {
			return memo[idx][tar] = 1;
		}

		//not needed
		if (idx == arr.length) {
			return memo[idx][tar] = 0;
		}

		if (memo[idx][tar] != -1) {
			return memo[idx][tar];
		}

		int ans = 0;

		for (int j = idx; j < arr.length; j++) {
			if (tar - arr[j] >= 0) {
				ans += rec_memo(j, arr, tar - arr[j], memo);
			}
		}
		
		/* This can also be instead of for loop, here memo must be till n+1 
		
		if (tar - arr[idx] >= 0) {
			ans += rec_memo(idx, arr, tar - arr[idx], memo);
		}

		ans += rec_memo(idx + 1, arr, tar, memo);
		*/

		return memo[idx][tar] = ans;
	}
	
	//Recursion
	public static int rec(int idx, int[] arr, int tar) {

		if (tar == 0) {
			return 1;
		}

		if (idx == arr.length) {
			return 0;
		}

		int ans = 0;

		// calling for each index and going for same index as well
		for (int j = idx; j <= arr.length; j++) {
			if (tar - arr[j] >= 0) {
				ans += rec(j, arr, tar - arr[j]);
			}
		}

		return ans;
	}
}