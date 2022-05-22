package dsalevel1.dynamicprogramming;

import java.util.*;

public class BuyAndSellStocksTwoTransactionsAllowed3dDpArray {

    public static void main(String[] args) throws Exception {
        // write your code here
    	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	int[] prices = new int[n];
    	for (int i = 0; i < n; i++) {
    		prices[i] = in.nextInt();
    	}
    	in.close();
    	
    	int K = 2;
        
        int[][][] dp = new int[n][K+1][2];
        
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= K; k++) {
                for (int x = 0; x < 2; x++) {
                    
                    //base case when k == 0
                    if (k == 0) {
                        if (x == 0) {
                            dp[i][k][x] = 0;
                        } else {
                            dp[i][k][x] = -(int)(1e9);
                        }
                    } else {
                        //if i == 0, then depend on i = -1
                        if (i == 0) {
                            if (x == 0) {
                                dp[i][k][x] = Math.max(0, -(int)(1e9) + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(-(int)(1e9), 0 - prices[i]);
                            }
                        } else {
                            //else x mathematically formula
                            if (x == 0) {
                                dp[i][k][x] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                            }
                        }
                    }
                }
            }
        } 
        
        System.out.println(dp[n-1][K][0]);
    }

}