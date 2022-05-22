package dsalevel1.dynamicprogramming;

import java.util.*;

public class BuyAndSellStocksTwoTransactionsAllowed {

    public static void main(String[] args) throws Exception {
        // write your code here
    	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	int[] prices = new int[n];
    	for (int i = 0; i < n; i++) {
    		prices[i] = in.nextInt();
    	}
    	in.close();
    	
    	int dpi10 = 0;
        int dpi20 = 0;
        int dpi11 = -(int)(1e9);
        int dpi21 = -(int)(1e9);
        
        //maintain 4 states total for 2 transactions
        for (int i = 0; i < prices.length; i++) {
            
            dpi20 = Math.max(dpi20, dpi21 + prices[i]);
            dpi21 = Math.max(dpi21, dpi10 - prices[i]);
            
            dpi10 = Math.max(dpi10, dpi11 + prices[i]);
            dpi11 = Math.max(dpi11, 0 - prices[i]);            
        }
        
        System.out.println(dpi20);
    }

}