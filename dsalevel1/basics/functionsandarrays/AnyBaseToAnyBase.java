package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class AnyBaseToAnyBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int sourceBase = scn.nextInt();
		int destBase = scn.nextInt();
		int res = convertBaseToBase(n, sourceBase, destBase);
		System.out.println(res);
		scn.close();
	}

	public static int convertBaseToBase(int n, int sourceBase, int destBase) {

		int val = getValueIndecimal(n, sourceBase);
		int res = getValueInBase(val, destBase);

		return res;
	}

	private static int getValueIndecimal(int n, int b) {
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
