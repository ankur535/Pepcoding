package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		int sp = n/2; 
		int stars = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sp; j++) {
				System.out.print("\t");
			}
			for (int j2 = 1; j2 <= stars; j2++) {
				System.out.print("*\t");
			}
			if (i <= n/2) {
				sp--;
				stars += 2;
			} else {
				sp++;
				stars -= 2;
			}
			System.out.println();
		}

	}

}
