package dsalevel1.dynamicprogramming;

import java.util.*;

public class BuyAndSellStocksWithTransactionFeeInfiniteTransactionsAllowed {

    public static void main(String[] args) throws Exception {
        // write your code here
    	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	int[] prices = new int[n];
    	for (int i = 0; i < n; i++) {
    		prices[i] = in.nextInt();
    	}

        int fee = in.nextInt();
    	in.close();

        int dpi0 = DpApproach(prices, fee);
        
        System.out.println(dpi0);
    }

	private static int DpApproach(int[] prices, int fee) {
		
		int dpi0 = 0;	//sell profit
        int dpi1 = -(int)(1e9);	//buy profit
        
        //here change is that we buy and sell stock multiple times
        //rather than buying only once
        //put fee on buying the stock
        
        for (int i = 0; i < prices.length; i++) {
            
            int dpi_10 = dpi0;
            
            //we can also put fees on selling the stock
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);	//selling the stock
            dpi1 = Math.max(dpi1, dpi_10 - prices[i] - fee);  //buying the stock
        }
		return dpi0;
	}

}