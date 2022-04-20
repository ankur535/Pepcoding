package dsalevel1.dynamicprogramming;

import java.util.*;

public class CountBinaryStrings {

	public static void main(String[] args) throws Exception {
		// write your code here
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		
		int ea0 = 1;
		int ea1 = 1;
		
		for (int i = 2; i <= n; i++) {
			
			int nea0 = ea1;
			int nea1 = ea0 + ea1;
			
			ea0 = nea0;
			ea1 = nea1;			
		}
		
		int total = ea0 + ea1;
		
		System.out.println(total);
	}

}