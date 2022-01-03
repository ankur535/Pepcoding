package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class AnyBaseAdditionPep {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int b = scn.nextInt();
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int res = getSum(b, n1, n2);
		System.out.println(res);
		scn.close();
	}

	public static int getSum(int b, int n1, int n2) {

		int carry = 0;
		int power = 1;
		int res = 0;
		while (n1 > 0 || n2 > 0 || carry > 0) {

			int digit1 = n1 % 10;
			int digit2 = n2 % 10;

			int sum = digit1 + digit2 + carry;

			carry = sum / b;
			sum = sum % b;

			res = res + sum * power;
			power *= 10;

			n1 /= 10;
			n2 /= 10;
		}
		return res;

	}

}
