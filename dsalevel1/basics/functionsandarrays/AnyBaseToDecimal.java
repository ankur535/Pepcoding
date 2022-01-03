package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class AnyBaseToDecimal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int b = scn.nextInt();
		int d = getValueIndecimal(n, b);
		System.out.println(d);
		scn.close();
	}

	public static int getValueIndecimal(int n, int b) {
		// write your code here
		int val = 0;
		int rem = 0;
		int power = 0;
		while (n > 0) {
			rem = n % 10;
			val = val + rem * (int) Math.pow(b, power);
			n = n / 10;
			power++;
		}

		return val;
	}
}
