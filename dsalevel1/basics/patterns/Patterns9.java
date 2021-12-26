package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		int sp = 1;
		int spb = n - 2;

		for (int i = 1; i <= n; i++) {
			// initial spaces
			for (int j = 1; j < sp; j++) {
				System.out.print("\t");
			}
			// stars
			System.out.print("*\t");
			// between spaces
			for (int j = 1; j <= spb; j++) {
				System.out.print("\t");
			}
			if (i != (n/2+1)) {
				System.out.print("*\t");
			}

			if (i <= n / 2) {
				sp++;
				spb -= 2;
			} else {
				sp--;
				spb += 2;
			}
			System.out.println();

		}

	}

}
