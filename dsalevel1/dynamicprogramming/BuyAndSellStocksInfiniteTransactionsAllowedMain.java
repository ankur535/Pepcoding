package dsalevel1.dynamicprogramming;

import java.util.*;

public class BuyAndSellStocksInfiniteTransactionsAllowedMain {

    public static void main(String[] args) throws Exception {
        // write your code here
    	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	int[] prices = new int[n];
    	for (int i = 0; i < n; i++) {
    		prices[i] = in.nextInt();
    	}
    	in.close();
    	
    	int dpi0 = 0;	//track maximum profit
        int dpi1 = -(int)(1e9); //Track how much profit left after buy at that point
        
        //here change is that we buy and sell stock multiple times
        //rather than buying only once
        for (int i = 0; i < prices.length; i++) {
            
            int dpi_10 = dpi0;
            
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);	//if we sell, we will have dpi1(after buy remaining value) + prices[i]
            dpi1 = Math.max(dpi1, dpi_10 - prices[i]);  //if we buy, we need to put out money from last total profit so dpi_10 - prices[i]
        }
        
        System.out.println(dpi0);
    }

}