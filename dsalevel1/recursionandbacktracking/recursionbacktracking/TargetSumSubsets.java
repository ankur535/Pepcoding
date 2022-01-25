package dsalevel1.recursionandbacktracking.recursionbacktracking;

import java.util.Scanner;

public class TargetSumSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int tar = in.nextInt();
		printTargetSumSubsets(arr, 0, "", 0, tar);
		in.close();
	}
	
	// asf is the subset 
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String asf, int sos, int tar) {
        
    	if(idx == arr.length) {
    		if (sos == tar) {
    			System.out.println(asf + ".");
    		}
    		return;
    	}
    	
    	if(sos > tar) {
    		return;
    	}
    	
    	//include
    	printTargetSumSubsets(arr, idx + 1, asf + arr[idx] + ", ", sos + arr[idx], tar);
    	
    	/* To make it follow backtracking
   	 
	   	//include
		sos += arr[idx];
		printTargetSumSubsets(arr, idx+1, asf + arr[idx] + ", ", sos, tar);
		sos -= arr[idx];
		
    	 */
    	
    	//exclude
    	printTargetSumSubsets(arr, idx + 1, asf, sos, tar);
    	
    }
}
