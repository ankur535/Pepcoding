package dsalevel1.dynamicprogramming;

import java.util.*;

public class MaximumSumNonAdjacentElements {

    public static void main(String[] args) throws Exception {

    	Scanner in= new Scanner(System.in);
    	
    	int n = in.nextInt();
    	
    	int[] arr = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		arr[i] = in.nextInt();
    	}
    	in.close();
    	
    	//int ans = tabulation(arr);
    	
    	int ans = tabulation2(arr);

    	System.out.println(ans);	    		
    }
    
    //Tabulation without any space as need only last values
    public static int tabulation2(int[] arr) {
    	
    	int inc = arr[0];
    	int exc = 0;
    	
    	for (int i = 1; i < arr.length; i++) {
    		
    		int ninc = exc + arr[i];
    		int nexc = Math.max(inc, exc);
    		
    		inc = ninc;
    		exc = nexc;
    	}
    	
    	int ans = Math.max(inc, exc);
    	
    	return ans;
    }
    
    //Tabulation using array space
    public static int tabulation(int[] arr) {
    	
    	int n = arr.length;
    	
    	//using inclusion and exclusion principle
    	int[] inc = new int[n];
    	int[] exc = new int[n];
    	
    	//for calculation see dry run
    	for (int i = 0; i < n; i++) {
    		
    		if (i == 0) {
    			inc[i] = arr[i];
    			exc[i] = 0;
    			continue;
    		}
    		
    		inc[i] = exc[i-1] + arr[i];
    		exc[i] = Math.max(inc[i-1], exc[i-1]);    		
    	}
    	
    	int ans = Math.max(inc[n-1], exc[n-1]);
    	
    	return ans;
    }
}