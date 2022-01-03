package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class DecimalToAnyBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int b = scn.nextInt();
		int dn = getValueInBase(n, b);
		System.out.println(dn);
		scn.close();
	}

	private static int getValueInBase(int n, int b) {
		// TODO Auto-generated method stub
		int rem = 0;
		int pow10 = 1;
		int val = 0;
		while (n > 0) {
			rem = n % b;
			val = val + rem * pow10;
			pow10 = pow10 * 10;
			n = n / b;
		}

		return val;
	}

}
