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
    	//int ans = rec(n, 0, arr);
    	
    	//int[] memo = new int[n+1];
    	//Arrays.fill(memo, -1);
    	
    	//int ans = rec_memo(n, 0, arr, memo);
    	
    	int ans = rec_tab(n, arr);
    	
    	System.out.println(ans);
    }
    
    //Tabulation
    public static int rec_tab(int n, int[] arr) {
    	
    	int[] dp = new int[n+1];
    	
    	for (int idx = n; idx >= 0; idx--) {
    		
    		if (idx == n) {
    			dp[idx] = 1;
    			continue;
    		}
    		
    		int jumps_allowed = arr[idx];
    		
    		int ans = 0;
    		
    		//result at a index will be the sum of that index + jumps answer from dp array
    		for (int i = 1; i <= jumps_allowed; i++) {
    			if (idx + i <= n) {
    				ans += dp[idx + i];
    			} else {
    				break;
    			}
    		}
    		
    		dp[idx] = ans;
    		
    	}
    	
    	return dp[0];
    }
    
    //memoization
    public static int rec_memo(int n, int idx, int[] arr, int[] memo) {
    	
    	if (idx == n) {
    		return memo[idx] = 1;
    	}
    	
    	if (memo[idx] != -1) return memo[idx];
    	
    	int jumps_allowed = arr[idx];
    	
    	int ans = 0;
    	
    	for (int i = 1; i <= jumps_allowed; i++) {
    		if (idx + i <= n) {
    			ans += rec_memo(n, idx + i, arr, memo);
    		} else {
    			break;
    		}
    	}
    	
    	return memo[idx] = ans;
    }
    
    //Recursion
    public static int rec(int n, int idx, int[] arr) {
    	
    	if (idx == n) {
    		return 1;
    	}
    	
    	int jumps_allowed = arr[idx];
    	
    	int ans = 0;
    	
    	//loop over the number of jumps allowed
    	for (int i = 1; i <= jumps_allowed; i++) {
    		if (idx + i <= n) {
    			ans += rec(n, idx + i, arr);
    		} else {
    			break;
    		}
    	}
    	
    	return ans;    	
    }
}