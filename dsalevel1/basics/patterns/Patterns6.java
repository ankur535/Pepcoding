package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		int stars = n/2 + 1;
		int sp = 1;

		for (int i = 1; i <= n; i++) {
			//stars
			for (int j = 1; j <= stars; j++) {
				System.out.print("*\t");
			}
			//spaces
			for (int k = 1; k <= sp; k++) {
				System.out.print("\t");
			}
			//stars
			for (int l = 1; l <= stars; l++) {
				System.out.print("*\t");
			}
		
			if (i <= n/2) {
				sp = sp + 2;
				stars--;
			} else {
				sp = sp - 2;
				stars++;
			}
			System.out.println();
		}

	}

}
