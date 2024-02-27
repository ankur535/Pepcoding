package dsalevel1.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaintHouseManyColors {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String nk[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		long[][] arr = new long[n][k];
		for (int i = 0; i < n; i++) {
			
			String[] parts = br.readLine().split(" ");
			
			for (int color = 0; color < k; color++) {
				arr[i][color] = Long.parseLong(parts[color]);
			}
		}
		
		//dry run to make it simple
		//long ans = tabulation(k, arr);
		
		//long ans = tabulation1(k, arr);
		
		long ans = tabulation2(k, arr);
		System.out.println(ans);
	}
	
	//Doing using 1-D Array and in n^2 time complexity
	private static long tabulation2(int k, long[][] arr) {

		int n = arr.length;

		long[] dp = new long[k];
		
		// To avoid n^3 and make it n^2 we can use below mini and second mini values.
		long mini = Long.MAX_VALUE;
		long secondMini = mini;

		// saving initial value from 1st row
		for (int color = 0; color < k; color++) {
			dp[color] = arr[0][color];
			
			//setting initial minimum and second minimum
			if (dp[color] < mini) {
				secondMini = mini;
				mini = dp[color];
			} else if (dp[color] < secondMini) {
				secondMini = dp[color];
			}
		}

		for (int i = 1; i < n; i++) {
			
			long nmini = Long.MAX_VALUE;
			long nsecondMini = nmini;
			
			long[] temp = new long[k];
			for (int color = 0; color < k; color++) {
				
				if (dp[color] == mini) {
					temp[color] = arr[i][color] + secondMini;
				} else {
					temp[color] = arr[i][color] + mini;
				}
				
				//setting new mini and secondmini to be used later for next round
				if (temp[color] < nmini) {
					nsecondMini = nmini;
					nmini = temp[color];
				} else if (temp[color] < nsecondMini) {
					nsecondMini = temp[color];
				}
				
			}
			
			mini = nmini;
			secondMini = nsecondMini;
			
			dp = temp;
		}
		
		//In the last, mini will become the answer
		return mini;
		
	}
	
	//converting n^3 to n^2 implementation
	@SuppressWarnings("unused")
	private static long tabulation1(int k, long[][] arr) {

		int n = arr.length;

		long[][] dp = new long[n][k];

		//To avoid n^3 and make it n^2 we can use below mini and second mini values.
		long mini = Long.MAX_VALUE;
		long secondMini = mini;
		
		for (int color = 0; color < k; color++) {
			dp[0][color]  = arr[0][color];
			
			//setting initial minimum and second minimum
			if (dp[0][color] < mini) {
				secondMini = mini;
				mini = dp[0][color];
			} else if (dp[0][color] < secondMini) {
				secondMini = dp[0][color];
			}
			
		}
		
		for (int i = 1; i < n; i++) {

			long nmini = Long.MAX_VALUE;
			long nsecondMini = nmini;
			
			// iterate over colors
			for (int color = 0; color < k; color++) {

				//this way avoided third loop
				if (dp[i-1][color] == mini) {
					dp[i][color] = arr[i][color] + secondMini;
				} else {
					dp[i][color] = arr[i][color] + mini;
				}
				
				//setting new mini and secondmini to be used later for next round
				if (dp[i][color] < nmini) {
					nsecondMini = nmini;
					nmini = dp[i][color];
				} else if (dp[i][color] < nsecondMini) {
					nsecondMini = dp[i][color];
				}
			}
			
			mini = nmini;
			secondMini = nsecondMini;
		}
		
		//In the last, mini will become the answer
		return mini;
	}
	
	// Similar to paint house with 3 colors questions but doing for k colors. 2-D Array
	@SuppressWarnings("unused")
	private static long tabulation(int k, long[][] arr) {

		int n = arr.length;

		long[][] dp = new long[n][k];

		for (int color = 0; color < k; color++) {
			dp[0][color]  = arr[0][color];
		}
		
		for (int i = 1; i < n; i++) {

			// iterate over colors
			for (int color = 0; color < k; color++) {
				
				// find minimum value from last round for color except the current color
				long min = Long.MAX_VALUE;

				for (int oldcolor = 0; oldcolor < k; oldcolor++) {
					if (oldcolor == color)
						continue;
					min = Math.min(min, dp[i - 1][oldcolor]);
				}

				// add last round minimum with current round color value
				dp[i][color] = arr[i][color] + min;
			}
		}

		long ans = Integer.MAX_VALUE;

		// find minimum from last values of dp array
		for (int color = 0; color < k; color++) {
			ans = Math.min(ans, dp[n - 1][color]);
		}

		return ans;
	}
		
	/* Test case
	* Do dry run: 
	* let 4 color: Red, Green, Blue, Yellow
		5 4
		4 3 2 5
		3 2 5 7
		8 9 2 1
		4 5 7 8
		7 8 9 2
		 
		Res -> 11 (Blue(2) -> Green(2) -> Yellow(1) -> Red(4) -> Yellow (2))
		  
	*/

}