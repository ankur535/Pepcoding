package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class AnyBaseSubtractionPep {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int b = scn.nextInt();
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int res = getDifference(b, n1, n2);
		System.out.println(res);
		scn.close();
	}

	public static int getDifference(int b, int n1, int n2) {

		int val = 0;
		int power = 1;

		while (n2 > 0) {

			int digit1 = n1 % 10;
			int digit2 = n2 % 10;

			int diff = digit2 - digit1;
			if (diff < 0) {
				diff = b + diff;
				n1 = n1 / 10;
				n2 = n2 / 10 - 1;
			} else {
				n1 = n1 / 10;
				n2 = n2 / 10;
			}

			val = val + diff * power;
			power *= 10;

		}
		return val;

	}

}
