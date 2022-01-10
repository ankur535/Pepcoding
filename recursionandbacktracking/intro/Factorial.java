package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(factorial(n));
		in.close();
	}

	public static int factorial(int n) {

		if (n == 0) {
			return 1;
		}
		int fnml = factorial(n - 1);
		int fn = n * fnml;
		return fn;

	}

}
