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
    	
    	int bp = 0;
    	int sp;
    	int totalProfit = 0;
    	
    	for (sp = 1; sp < n; sp++) {
    		
    		//whenever we start getting a depression in stock, sell it and buy again at new lower value
    		if (prices[sp] < prices[sp-1]) {
    			totalProfit += prices[sp - 1] - prices[bp];
    			bp = sp;
    		}
    	}
    	
    	//in the last if no depression found, then sell stock at last day or selling point
    	totalProfit += prices[sp-1] - prices[bp];
    	System.out.println(totalProfit);
    }

}