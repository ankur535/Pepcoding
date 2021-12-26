package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class FibonacciNumbersTillN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int low = 0, high = 1, val = 0;
		for (int i = 1; i <= n; i++) {
			System.out.println(low);
			val = low + high;
			low = high;
			high = val;
		}
	}
}
