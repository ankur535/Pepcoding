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

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'a') {
				sa = 1 + 2 * sa;
			} else if (s.charAt(i) == 'b') {
				sab = sa + 2 * sab;
			} else if (s.charAt(i) == 'c') {
				sabc = sab + 2 * sabc;
			}
		}

		return sabc;
	}
}