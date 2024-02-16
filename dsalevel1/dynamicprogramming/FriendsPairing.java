package dsalevel1.dynamicprogramming;

import java.util.*;

public class FriendsPairing {

    public static void main(String[] args) throws Exception {
        // write your code here
    	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	in.close();
    	
    	//int ans = rec(n);
    	
    	/*
    	int[] memo = new int[n+1];
    	int ans = rec_memo(n, memo);
    	*/
    	
    	//int ans = rec_tab(n);
    	
    	int ans = tab_better(n);
    	
    	System.out.println(ans);
    }
    
    //Tabulation better
    public static int tab_better(int N) {
    	
    	int a = 1;
    	int b = 1;
    	
    	for (int n = 2; n <= N; n++) {
    		
    		int single = b;
    		
    		int pairUp = a * (n-1);
    		
    		int c = single + pairUp;   				
    				
    		a = b;
    		b = c;
    	}
    	
    	return b;
    }
    
    //Tabulation
    public static int rec_tab(int N) {
    	
    	int[] dp = new int[N+1];
    	
    	for (int n = 0; n <= N; n++) {
    		
    		if (n == 0 || n == 1) {
    			dp[n] = 1;
    			continue;
    		}
    		
    		int single = dp[n-1];
    		
    		int pairUp = (dp[n-2]) * (n-1);
    		
    		dp[n] = single + pairUp;
    	}
    	
    	return dp[N];
    }
    
    //Memoization
    public static int rec_memo(int n, int[] memo) {
    	
    	if (n == 0 || n == 1) return memo[n] = 1; 
    	
    	if (memo[n] != 0) return memo[n];
    	
    	int single = rec_memo(n-1, memo);
    	
    	int pairUp = rec_memo(n-2, memo) * (n-1);
    	
    	return memo[n] = single + pairUp;
    }
    
    //Recursion
    public static int rec(int n) {
    	
    	if (n == 0 || n == 1) return 1;
    	
    	int single = rec(n-1);
    	
    	int pairUp = rec(n-2) * (n-1);
    	
    	return single + pairUp;
    }

}