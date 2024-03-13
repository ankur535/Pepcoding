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
    	
    	//int maxProfit = TwoArrayApproach(n, prices);
    	
    	int maxProfit = DpApproach(n, prices);
        
        System.out.println(maxProfit);
    }


	private static int DpApproach(int n, int[] prices) {
		int dpi10 = 0;
        int dpi20 = 0;
        int dpi11 = -(int)(1e9);
        int dpi21 = -(int)(1e9);
        
        //maintain 4 states total for 2 transactions
        for (int i = 0; i < n; i++) {
            
        	//sell2 depend on buy2, buy2 depends on sell1
        	//sell1 depend on buy1, buy1 depends on nothing
        	        	
            dpi20 = Math.max(dpi20, dpi21 + prices[i]);
            dpi21 = Math.max(dpi21, dpi10 - prices[i]);
            
            dpi10 = Math.max(dpi10, dpi11 + prices[i]);
            dpi11 = Math.max(dpi11, 0 - prices[i]);            
        }
		return dpi20;
	}
    
    
    //Other simple way
    @SuppressWarnings("unused")
	private static int TwoArrayApproach(int n, int[] arr) {

		//forward moving array with max profit if sold today(MAPST)
		int mapst = 0;
		int mintn = arr[0]; //min till now from start
		
		int[] dpl = new int[n];
		for (int i = 1; i < n; i++) {
			
			if (arr[i] < mintn) {
				mintn = arr[i];
			}
			
			mapst = arr[i] - mintn;
			if (mapst > dpl[i-1]) {
				dpl[i] = mapst;
			} else {
				dpl[i] = dpl[i-1];
			}
		}
		
		//backward moving array with max profit if buy today(MAPBT)
		int mapbt = 0;
		int maxtn = arr[n-1]; //max till now from end
		
		int[] dpr = new int[n];
		for (int i = n-2; i >= 0; i--) {
			
			if (arr[i] > maxtn) {
				maxtn = arr[i];
			}
			
			mapbt = maxtn - arr[i];
			if (mapbt > dpr[i+1]) {
				dpr[i] = mapbt;
			} else {
				dpr[i] = dpr[i+1];
			}
		}
		
		//calculate max at a index from both array
		int maxres = 0;
		for (int i = 0; i < n; i++) {
			maxres = Math.max(maxres, dpr[i] + dpl[i]);
		}
		
		return maxres;
		
	}

}