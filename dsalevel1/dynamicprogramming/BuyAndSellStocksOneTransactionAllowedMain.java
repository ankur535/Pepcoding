package dsalevel1.dynamicprogramming;

import java.util.*;

public class BuyAndSellStocksOneTransactionAllowedMain {

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
        int dpi1 = -(int)(1e9);
        
        //check dp states in copy to understand logic
        //dpi0 and dpi1 denotes ith prices with 0 or 1 stock at present
        //using previous day maximum profit
        for (int i = 0; i < prices.length; i++) {
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, 0 - prices[i]);            
        }

		System.out.println(dpi0);
		
		/*
		//Value based Approach
		int maxProfit = 0;
		// buying point
		int bp = prices[0];

		for (int i = 1; i < n; i++) {

			// selling point
			int sp = prices[i];

			// if sp is lower, this will be new buying point for remaining values
			if (sp < bp) {
				bp = sp;
			} else {
				//take maximum profit values
				int profit = sp - bp;
				maxProfit = Math.max(maxProfit, profit);
			}
		}
		*/
		
		//Pointer/Index based Approach
		/*
		 //initial buying point index
		 int bp = 0;
		int maxProfit = 0;

		//Loop over each selling point index
		for (int sp = 1; sp < n; sp++) {

			if (prices[bp] > prices[sp]) {
				bp = sp;
			} else {
				maxProfit = Math.max(maxProfit, prices[sp] - prices[bp]);
			}
		}
		 */
		

		//System.out.println(maxProfit);
	}

}