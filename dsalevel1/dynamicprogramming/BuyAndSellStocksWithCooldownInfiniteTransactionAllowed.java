package dsalevel1.dynamicprogramming;

import java.util.*;

public class BuyAndSellStocksWithCooldownInfiniteTransactionAllowed {

    public static void main(String[] args) throws Exception {
        // write your code here
    	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	int[] prices = new int[n];
    	for (int i = 0; i < n; i++) {
    		prices[i] = in.nextInt();
    	}
    	in.close();
    	
    	int dpi0 = 0;
        int dpi0_prev = 0;
        int dpi1 = -(int)(1e9);
        
        //here we will look 2 step back on buying the stock
        //so that we can get 1 day cooldown period
        for (int i = 0; i < prices.length; i++) {
            
            int dpi_10 = dpi0;
            
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dpi0_prev - prices[i]);
            
            dpi0_prev = dpi_10;            
        }
        
        System.out.println(dpi0);
    }

}