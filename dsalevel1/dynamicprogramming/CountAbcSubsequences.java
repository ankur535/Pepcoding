package dsalevel1.dynamicprogramming;

import java.util.*;

public class CountAbcSubsequences {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		in.close();
		
		int ans = subsequence(s);

		System.out.println(ans);
	}

	// Direct doing with DP
	public static int subsequence(String s) {
		// Write your code here
		int sa = 0;
		int sab = 0;
		int sabc = 0;
		
		//For each character we have 2 options
		//1. Append it or don't append it to previous value, so doing 2 * sa or 2 * sab or 2 * sabc
		//2. it will append to previous string, like b will append to all values of a (so adding sa),
		//and c will append behind ab value (so adding sab), for a it will addition of 1 for new value.

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'a') {
				sa = 2 * sa + 1;
			} else if (s.charAt(i) == 'b') {
				sab = 2 * sab + sa;
			} else if (s.charAt(i) == 'c') {
				sabc = 2 * sabc + sab;
			}
		}

		return sabc;
	}
}