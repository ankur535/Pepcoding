package dsalevel1.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaintHouse {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {

			String[] parts = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(parts[0]);
			arr[i][1] = Integer.parseInt(parts[1]);
			arr[i][2] = Integer.parseInt(parts[2]);
		}
		br.close();

		// use long instead of int due to high constraints

		// long ans = tabulation(arr);

		//long ans = tabulation2(arr);
		
		long ans = tabulation3(arr);

		System.out.println(ans);
	}
	
	//Using 3 variables instead of keeping array
	public static long tabulation3(int[][] arr) {

		int n = arr.length;

		long r = arr[0][0];
		long b = arr[0][1];
		long g = arr[0][2];

		for (int i = 1; i < n; i++) {

			long nr = arr[i][0] + Math.min(b, g);
			long nb = arr[i][1] + Math.min(r, g);
			long ng = arr[i][2] + Math.min(r, b);

			r = nr;
			b = nb;
			g = ng;

		}

		long ans = Math.min(b, g);
		ans = Math.min(ans, r);

		return ans;
	}

	// Tabulation using single dp 2-D array space
	public static long tabulation2(int[][] arr) {

		int n = arr.length;

		long dp[][] = new long[3][n];

		dp[0][0] = arr[0][0]; // red
		dp[1][0] = arr[0][1]; // blue
		dp[2][0] = arr[0][2]; // green

		for (int i = 1; i < n; i++) {

			dp[0][i] = arr[i][0] + Math.min(dp[1][i - 1], dp[2][i - 1]); // red: dp of ith depend on arr value and min of green and blue i-1th value
			dp[1][i] = arr[i][1] + Math.min(dp[0][i - 1], dp[2][i - 1]); // blue: dp of ith depend on arr value and min of green and red i-1th value
			dp[2][i] = arr[i][2] + Math.min(dp[0][i - 1], dp[1][i - 1]); // green: dp of ith depend on arr value and min of red and blue i-1th value

		}

		long ans = Math.min(dp[0][n - 1], dp[1][n - 1]);
		ans = Math.min(ans, dp[0][n - 1]);

		return ans;
	}

	// Tabulation using 3 different 1-D array space
	public static long tabulation(int[][] arr) {

		int n = arr.length;

		// using 2 arrays r, g, b and going 1 step ahead based on last step

		long red[] = new long[n];
		long blue[] = new long[n];
		long green[] = new long[n];

		for (int i = 0; i < n; i++) {

			int r = arr[i][0];
			int b = arr[i][1];
			int g = arr[i][2];

			if (i == 0) {
				red[i] = r;
				blue[i] = b;
				green[i] = g;
				continue;
			}

			// red will depend on last round green or blue.
			// same way other will depend on remaining 2

			long nr = r + Math.min(green[i - 1], blue[i - 1]);
			long nb = b + Math.min(red[i - 1], green[i - 1]);
			long ng = g + Math.min(red[i - 1], blue[i - 1]);

			red[i] = nr;
			blue[i] = nb;
			green[i] = ng;

		}

		long ans = Math.min(green[n - 1], blue[n - 1]);
		ans = Math.min(ans, red[n - 1]);

		return ans;
	}

}