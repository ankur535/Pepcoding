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
    	
    	//int totalProfit = IndexBasedApproach(n, prices);
    	
    	int totalProfit = DpApproach(n, prices);
    	
    	System.out.println(totalProfit);
    }
    
    
    private static int DpApproach(int n, int[] prices) {
    	int dpi0 = 0;	//track maximum profit
        int dpi1 = -(int)(1e9); //Track how much profit left after buy at that point
        
        //here change is that we buy and sell stock multiple times
        //rather than buying only once
        for (int i = 0; i < prices.length; i++) {
            
            int dpi_10 = dpi0;
            
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);	//if we sell, we will have dpi1(after buy remaining value) + prices[i]
            dpi1 = Math.max(dpi1, dpi_10 - prices[i]);  //if we buy, we need to put out money from last total profit so dpi_10 - prices[i]
        }
        
        return dpi0;
	}
    

	@SuppressWarnings("unused")
	private static int IndexBasedApproach(int n, int[] prices) {
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
		return totalProfit;
	}

}