package dsalevel1.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaintFence {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int ans = tabulation(n, k);

		System.out.println(ans);
	}
	
	//Using 3 variables instead of keeping array
	public static int tabulation(int n, int k) {

		//do a dry run to understand, take 2 row: sameColor and diffColor
		//and take column as number of n
		
		//initialize for n = 1
		int sameColor = 0;
		int diffColor = k;
		int total = sameColor + diffColor;
		
		for (int i = 2; i <= n; i++) {
			
			sameColor = diffColor;
			diffColor = total * (k-1);
			total = sameColor + diffColor;
		}
		
		return total;
	}
}