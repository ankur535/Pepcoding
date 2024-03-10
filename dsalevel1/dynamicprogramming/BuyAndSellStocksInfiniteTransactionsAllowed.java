package dsalevel1.dynamicprogramming;

import java.util.*;

public class BuyAndSellStocksInfiniteTransactionsAllowed {

    public static void main(String[] args) throws Exception {
        // write your code here
    	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	int[] prices = new int[n];
    	for (int i = 0; i < n; i++) {
    		prices[i] = in.nextInt();
    	}
    	in.close();
    	
    	int bi = 0; // buying index
    	int si;		//selling index
    	int totalProfit = 0;
    	
    	for (si = 1; si < n; si++) {
    		
    		//whenever we start getting a depression in stock, sell it and buy again at new lower value
    		if (prices[si] < prices[si-1]) {
    			totalProfit += prices[si - 1] - prices[bi];
    			bi = si;
    		}
    	}
    	
    	//in the last if no depression found, then sell stock at last day or selling point
    	totalProfit += prices[si-1] - prices[bi];
    	System.out.println(totalProfit);
    }

}