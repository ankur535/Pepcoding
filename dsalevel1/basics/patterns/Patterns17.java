package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int sp = n/2;
		int stars = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sp; j++) {
				if (i == (n/2 +1)) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("*\t");
			}
			System.out.println();
			if (i <= n/2) {
				stars++;
			} else {
				stars--;
			}
		}
	}

}
