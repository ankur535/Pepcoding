package dsalevel1.dynamicprogramming;

import java.util.*;

public class TargetSumSubsetsDP {

    public static void main(String[] args) throws Exception {
    	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	int[] arr = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		arr[i] = in.nextInt();
    	}
    	
    	int tar = in.nextInt();
    	in.close();
    	
    	//for o towards n 
    	//boolean ans = rec(0, tar, arr);
    	
    	/*int[][] memo = new int[n+1][tar+1];
    	for (int[] m: memo) {
    		Arrays.fill(m, -1);
    	}
    	
    	boolean ans = rec_memo(0, tar, arr, memo);
    	*/
    	
    	//for n towards 0
    	//boolean ans = rec2(n, tar, arr);
    	
    	boolean ans = rec2_tab(arr, tar);
    	
    	System.out.println(ans);
    }
    
    //Tabulation from n to 0, very easy
    public static boolean rec2_tab(int[] arr, int Tar) {
    	
    	int n = arr.length;
    	
    	boolean[][] dp = new boolean[n+1][Tar + 1];
    	
    	for (int idx = 0; idx <= n; idx++) {
    		for (int tar = 0; tar <= Tar; tar++) {
    			
    			//base case, for column 0
    			if (tar == 0) {
    				dp[idx][tar] = true;
    				continue;
    			}
    			
    			//base case, for row o
    			if (idx == 0) {
    				dp[idx][tar] = false;
    				continue;
    			}
    			
    			//include, very simple code
    			if (tar - arr[idx-1] >= 0) {
    				dp[idx][tar] = dp[idx - 1][tar - arr[idx-1]];
    			}
    			
    			//don't include
    			dp[idx][tar] = dp[idx][tar] || dp[idx-1][tar];
    		}
    	}
    	
    	return dp[n][Tar];
    }
    
    //Recursion from n towards 0
    public static boolean rec2(int idx, int tar, int[] arr) {
    	
    	if (tar == 0) {
    		return true;
    	}
    	
    	if (idx == 0) {
    		return false;
    	}
    	
    	boolean ans = false;
    	
    	//include, check recursive tree for n to 0
    	//for target at idx and to go to (idx - 1), we should check that it shouldn't be negative
    	if (tar - arr[idx-1] >= 0) {
    		ans = rec2(idx - 1, tar - arr[idx-1], arr);
    	}
    	
    	//don't include
    	ans = ans || rec2(idx - 1, tar, arr);
    	
    	return ans;    	
    }
    
    //Memoization from 0 to n
    public static boolean rec_memo(int idx, int tar, int[] arr, int[][] memo) {
    	
    	//if target reached
    	if (tar == 0) {
    		memo[idx][tar] = 1;
    		return true;
    	}
		
    	//if end of array reached
    	if (idx == arr.length) {
    		memo[idx][tar] = 0;
    		return false;
    	}
    	
    	//checking in memo array
    	if (memo[idx][tar] != -1) {
    		return memo[idx][tar] == 0? false : true;
    	}
    	
    	boolean ans = false;
    	
    	//include
    	if (tar - arr[idx] >= 0) {
    		ans = rec_memo(idx + 1, tar - arr[idx], arr, memo);
    	} 
    	
    	//don't include
    	ans = ans || rec_memo(idx + 1, tar, arr, memo);
    	
    	if (ans) memo[idx][tar] = 1;
    	else memo[idx][tar] = 0;
    	
    	return ans;    	
    }
    
    //Recursion from 0 to n
    public static boolean rec(int idx, int tar, int[] arr) {
    	
    	//if reached target
    	if (tar == 0) {
    		return true;
    	}
    	
    	//if reached end of index, but not matching target
    	if (idx == arr.length) {
    		return false;
    	}
    	
    	boolean ans = false;
    	
    	//include value, proactively check for negative values
    	if (tar - arr[idx] >= 0) {
        	ans = rec(idx + 1, tar - arr[idx], arr);
    	}
    	
    	//don't include
    	ans = ans || rec(idx + 1, tar, arr);
    	
    	return ans;
    }
}