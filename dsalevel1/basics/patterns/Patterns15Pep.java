package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns15Pep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int stars = 1;
		int sp = n/2;
		int val = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sp; j++) {
				System.out.print("\t");
			}
			int num = val;
			for (int j = 1; j <= stars; j++) {
				System.out.print(num + "\t");
				if (j <= stars/2) {
					num++;
				} else {
					num--;
				}
			}
			System.out.println();
			if (i <= n/2) {
				sp--;
				stars += 2;
				val++;
			} else {
				sp++;
				stars -= 2;
				val--;
			}
		}
	}
}
