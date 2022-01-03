package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class AnyBaseMultiplicationPep {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int b = scn.nextInt();
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int res = getProduct(b, n1, n2);
		System.out.println(res);
		scn.close();
	}

	public static int getProduct(int b, int n1, int n2) {

		int res = 0;
		int power10 = 1;
		while (n2 > 0) {
			int d2 = n2 % 10;
			int sum = getProductWithSingleDigit(b, n1, d2);
			res = getSum(b, res, sum*power10);
			n2 = n2 / 10;
			power10 *= 10;
		}

		return res;
	}

	public static int getProductWithSingleDigit(int b, int n1, int d2) {

		int res = 0;
		int carry = 0;
		int power = 1;
		while (n1 > 0 || carry > 0) {

			int digit = n1 % 10;
			int val = digit * d2 + carry;

			carry = val / b;
			val = val % b;

			res += val * power;

			power *= 10;
			n1 = n1 / 10;
		}
		return res;
	}

	public static int getSum(int b, int n1, int n2) {

		int carry = 0;
		int res = 0;
		int power = 1;
		while (n1 > 0 || n2 > 0 || carry > 0) {

			int digit1 = n1 % 10;
			int digit2 = n2 % 10;
			n1 = n1 / 10;
			n2 = n2 / 10;

			int val = digit1 + digit2 + carry;
			carry = val / b;
			val = val % b;

			res = res + val * power;
			power *= 10;
		}

		return res;

	}

}
