package dsalevel1.dynamicprogramming;

import java.util.*;

public class ClimbStairsWithMinimumMoves {

	public static void main(String[] args) throws Exception {
        // write your code here
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	int arr[] = new int[n];
    	for (int i = 0; i < n; i++) {
    		arr[i] = in.nextInt();
    	}
    	
    	in.close();
    	
    	//int ans = rec(n, 0, arr);
    	
    	//int[] memo = new int[n+1];
    	//Arrays.fill(memo, -1);
    	
    	//int ans = rec_memo(n, 0, arr, memo);
    	
    	int ans = rec_tab(n, arr);
    	
    	if (ans == (int)(1e8) + 1) {
        	System.out.println("null");    	
    	} else {
        	System.out.println(ans);    	
    	}
    	
    }
	
	public static int rec_tab(int n, int[] arr) {
		
		int[] dp = new int[n+1];
		
		//run from n to 0
		for (int idx = n; idx >= 0; idx--) {
			
			if (idx == n) {
				dp[idx] = 0;
				continue;
			}
			
			int jumps_allowed = arr[idx];
			
			int ans = (int)(1e8);
			
			//use dp array with forward jumps
			for (int i = 1; i <= jumps_allowed; i++) {
				
				if (idx + i <= n) {
					ans = Math.min(ans, dp[idx + i]);
				} else {
					break;
				}
			}
			
			dp[idx] = ans + 1;
		}
		
		return dp[0];		
	}
	
	//Memoization
	public static int rec_memo(int n, int idx, int[] arr, int[] memo) {
		
		if (idx == n) {
			return memo[idx] = 0;
		}
		
		if (memo[idx] != -1) return memo[idx];
		
		int jumps_allowed = arr[idx];
		
		int ans = (int)(1e8);
		
		for (int i = 1; i <= jumps_allowed; i++) {
			if (idx + i <= n) {
				ans = Math.min(ans, rec_memo(n, idx + i, arr, memo));
			} else {
				break;
			}
		}
		
		return memo[idx] = ans + 1;		
	}

    //Recursion
    public static int rec(int n, int idx, int[] arr) {
    	
    	if (idx == n) return 0;
    	
    	int jumps_allowed = arr[idx];
    	
    	int ans = (int)(1e8);
    	
    	for (int i = 1; i <= jumps_allowed; i++) {
    		
    		if (idx + i <= n) {
    			ans = Math.min(ans, rec(n, idx + i, arr));
    		} else {
				break;
			}
    	}

		//ans will be min + 1
    	return ans + 1;
    }
}