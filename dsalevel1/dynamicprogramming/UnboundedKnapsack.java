package dsalevel1.dynamicprogramming;

import java.util.*;

public class UnboundedKnapsack {

    public static void main(String[] args) throws Exception {
    	
    	Scanner in = new Scanner(System.in);
    	
    	int n = in.nextInt();
    	
    	int[] values = new int[n];
    	int[] weights = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		values[i] = in.nextInt();
    	}
    	
    	for (int i = 0; i < n; i++) {
    		weights[i] = in.nextInt();
    	}
    	
    	int cap = in.nextInt();
    	in.close();
    	
    	//moving from 0 to n
    	//int ans = rec(0, values, weights, cap);
    	
    	/*
    	int[][] memo = new int[n+1][cap+1];
    	for (int[] m: memo) {
    		Arrays.fill(m, -1);
    	}
    	
    	int ans = rec_memo(0, values, weights, cap, memo);
    	
    	int ans = rec_tab(values, weights, cap);
    	*/
    	
    	//moving from n to 0
    	//int ans = rec2(n, values, weights, cap);
    	
    	/*
    	int[][] memo = new int[n+1][cap+1];
    	for (int[] m: memo) {
    		Arrays.fill(m, -1);
    	}
    	
    	int ans = rec_memo2(n, values, weights, cap, memo);
    	*/
    	
    	int ans = rec_tab2(values, weights, cap);
    	
    	System.out.println(ans);
    }
    
    //Tabulation
    public static int rec_tab2(int[] values, int[] weights, int Cap) {
    	
    	int n = weights.length;
    	
    	int[][] dp = new int[n+1][Cap+1];
    	
    	for (int idx = 0; idx <= n; idx++) {
    		for (int cap = 0; cap <= Cap; cap++) {
    			
    			if (idx == 0 || cap == 0) {
    				dp[idx][cap] = 0;
    				continue;
    			}
    			
    			int ans = 0;
    			
    			//include
    			if (cap - weights[idx - 1] >= 0) {
    				ans = dp[idx][cap - weights[idx - 1]] + values[idx - 1];
    			}
    			
    			//don't include
    			ans = Math.max(ans, dp[idx - 1][cap]);
    			
    			dp[idx][cap] = ans;
    		}
    	}
    	
    	return dp[n][Cap];
    }
    
    //Memoization
    public static int rec_memo2(int idx, int[] values, int[] weights, int cap, int[][] memo) {
    	
    	if (idx == 0 || cap == 0) {
    		return 0;
    	}
    	
    	if (memo[idx][cap] != -1) return memo[idx][cap];
    	
    	int ans = 0;
    	
    	if (cap - weights[idx-1] >= 0) {
    		ans = rec_memo2(idx, values, weights, cap - weights[idx-1], memo) + values[idx-1];
    	}
    	
    	ans = Math.max(ans, rec_memo2(idx - 1, values, weights, cap, memo));
    	
    	return memo[idx][cap] = ans;
    }
    
    //Recursion
    public static int rec2(int idx, int[] values, int[] weights, int cap) {
    	
    	if (idx == 0 || cap == 0) {
    		return 0;
    	}
    	
    	int ans = 0;
    	
    	if (cap - weights[idx-1] >= 0) {
    		ans = rec2(idx, values, weights, cap - weights[idx-1]) + values[idx-1];
    	}
    	
    	ans = Math.max(ans, rec2(idx - 1, values, weights, cap));
    	
    	return ans;
    }
    
    //Tabulation for 0 to n movement, will be filled bottom up
    @SuppressWarnings("unused")
	private static int rec_tab(int Cap, int[] values, int[] weights) {

		int n = values.length;
		
		int[][] dp = new int[n+1][Cap+1];
		
		for (int idx = n; idx >= 0; idx--) {
			for (int cap = 0; cap <= Cap; cap++) {
				
				if (idx == n) {
					dp[idx][cap] = 0;
					continue;
				}
				
				if (cap == 0) {
					dp[idx][cap] = 0;
					continue;
				}
				
				int maxp = 0;
				
				//take same index, don't go ahead
				if (cap - weights[idx] >= 0) {
					maxp = dp[idx][cap - weights[idx]] + values[idx];
				}
				
				maxp = Math.max(maxp, dp[idx+1][cap]);
				
				dp[idx][cap] = maxp;
			}
		}


		//Printing dp array
		for (int[] m : dp) {
			for (int i : m) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		return dp[0][Cap];
	}
    
    
    //Memoization
    public static int rec_memo(int idx, int[] values, int[] weights, int cap, int[][] memo) {
    	
    	if (cap == 0 || idx == weights.length) {
    		return memo[idx][cap] = 0;
    	}
    	
    	if (memo[idx][cap] != -1) return memo[idx][cap];
    	
    	int ans = 0;
    	
    	//include
    	if (cap - weights[idx] >= 0) {
    		ans = rec_memo(idx, values, weights, cap - weights[idx], memo) + values[idx];
    	}
    	
    	//don't include
    	ans = Math.max(ans, rec_memo(idx + 1, values, weights, cap, memo));
    	
    	return memo[idx][cap] = ans;    	
    }
    
    //Recursion
    public static int rec(int idx, int[] values, int[] weights, int cap) {
    	
    	if (cap == 0) {
    		return 0;
    	}
    	
    	if (idx == weights.length) {
    		return 0;
    	}
    	
    	int ans = 0;
    	
    	//include, on returning add the value for the included weight
    	if (cap - weights[idx] >= 0) {
    		ans = rec(idx, values, weights, cap - weights[idx]) + values[idx];
    	}
    	
    	//don't include, as not including so not adding the value for idx
    	ans = Math.max(ans, rec(idx + 1, values, weights, cap));
    	
    	return ans;
    }
}