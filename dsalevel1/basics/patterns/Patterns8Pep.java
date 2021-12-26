package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns8Pep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (i == j) {
					System.out.println("*");
				} else {
					System.out.print("\t");
				}
			}
		}

	}

}
