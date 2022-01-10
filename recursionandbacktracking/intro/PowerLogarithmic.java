package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class PowerLogarithmic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int n = in.nextInt();
		System.out.println(power(x, n));
		in.close();
	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}
		int t = power(x, n / 2);
		int res = t * t;
		if (n % 2 != 0) {
			res = res * x;
		}

		return res;
	}

}
