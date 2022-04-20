package dsalevel1.dynamicprogramming;

import java.util.*;

public class CountEncodings {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		String str = in.nextLine();
		//int ans = rec(str, 0);
		
		/*
		int[] memo = new int[str.length() + 1];
		Arrays.fill(memo, -1);
		
		int ans = rec_memo(str, 0, memo);
		*/
		
		int ans = rec_tab(str);
		System.out.println(ans);

		in.close();
	}
	
	//Tabulation
	public static int rec_tab(String str) {
		
		int n = str.length();
		
		int[] dp = new int[n+1];
		
		for (int idx = n; idx >= 0; idx--) {
			
			if (idx == n) {
				dp[idx] = 1;
				continue;
			}
			
			if (str.charAt(idx) == '0') {
				dp[idx] = 0;
				continue;
			}
			
			//take 1 char
			int ans = dp[idx + 1];
			
			//take 2 chars
			if (idx + 2 <= n) {
				String sub = str.substring(idx, idx + 2);
				if (Integer.parseInt(sub) <= 26) {
					ans += dp[idx + 2];
				}
			}
			
			dp[idx] = ans;		
		}
		
		return dp[0];
	}
	
	//Memoization
	public static int rec_memo(String str, int idx, int[] memo) {
		
		if (idx == str.length()) {
			return memo[idx] = 1;
		}
		
		//if 0 is first char
		if (str.charAt(idx) == '0') {
			return memo[idx] = 0;
		}
		
		if (memo[idx] != -1) return memo[idx];
        
		int ans = 0;
		
		//take 1 char
		ans += rec_memo(str, idx + 1, memo);
		
		//take 2 chars
		if (idx + 2 <= str.length()) {
			String sub = str.substring(idx, idx + 2);
			if (Integer.parseInt(sub) <= 26) {
				ans += rec_memo(str, idx + 2, memo);
			}
		}
		
		return memo[idx] = ans;
	}
	
	//Recursiom
	public static int rec(String str, int idx) {
		
		if (idx == str.length()) {
			return 1;
		}
		
		//if 0 is first char
		if (str.charAt(idx) == '0') {
			return 0;
		}
		
		int ans = 0;
		
		//take 1 char
		ans += rec(str, idx + 1);
		
		//take 2 chars
		if (idx + 2 <= str.length()) {
			String sub = str.substring(idx, idx + 2);
			//if char btw 1 and 26 means a and z
			if (Integer.parseInt(sub) <= 26) {
				ans += rec(str, idx + 2);
			}
			
		}
		
		return ans;
	}
}