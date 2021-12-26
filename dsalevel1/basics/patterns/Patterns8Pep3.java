package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns8Pep3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if ((i+j) == (n+1)) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}

	}

}
