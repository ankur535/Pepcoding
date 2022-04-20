package dsalevel1.dynamicprogramming;

import java.util.*;

public class CoinChangePermutations {

    public static void main(String[] args) throws Exception {

    	Scanner in = new Scanner(System.in);
    	
    	int n = in.nextInt();
    	
    	int[] arr = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		arr[i] = in.nextInt();
    	}
    	
    	int tar = in.nextInt();
    	in.close();
    	
    	//int ans = rec(arr, tar);
    	
    	//int[] memo = new int[tar+1];
    	//int ans = rec_memo(arr, tar, memo);
    	
    	int ans = rec_tab(arr, tar);
    	
    	System.out.println(ans);
    }
    
    //Tabulation
    public static int rec_tab(int[] arr, int Tar) {
    
    	int[] dp = new int[Tar + 1];
    	
    	//for each target move in array for subtract array value from target and whatever is at that index
    	//add it up for this target index
    	for (int tar = 0; tar <= Tar; tar++) {
    		
    		if (tar == 0) {
    			dp[tar] = 1;
    			continue;
    		}
    		
    		int ans = 0;
    		
    		for (int idx = 0; idx < arr.length; idx++) {
    			if (tar - arr[idx] >= 0) {
    				ans += dp[tar - arr[idx]];
    			}    			
    		}
    		
    		dp[tar] = ans;
    	}
    	
    	return dp[Tar];
    }
    
    //Memoization
    public static int rec_memo(int[] arr, int tar, int[] memo) {
    	
    	if (tar == 0) {
    		return memo[tar] = 1;
    	}
    	
    	if (memo[tar] != 0) return memo[tar];
    	
    	int ans = 0;
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (tar - arr[i] >= 0) {
    			ans += rec_memo(arr, tar - arr[i], memo);
    		}
    	}
    	
    	return memo[tar] = ans;
    }
    
    //Recursion
    public static int rec(int[] arr, int tar) {
    	
    	if (tar == 0) {
    		return 1;
    	}
    	
    	int ans = 0;
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (tar - arr[i] >= 0) {
    			ans += rec(arr, tar - arr[i]);
    		}
    	}
    	
    	return ans;
    }
}