package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns18Pep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int sp = 0;
		int stars = n;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sp; j++) {
				System.out.print("\t");
			}
			
			for (int j = 1; j <= stars; j++) {
				if (i > 1 && i <=(n/2) && j > 1 && j < stars) {
					System.out.print("\t");
				} else {
					System.out.print("*\t");
				}
			}
			System.out.println();
		
			if (i <= n/2) {
				sp++;
				stars -= 2;
			} else {
				sp--;
				stars += 2;
			}
			
		}
	}

}
