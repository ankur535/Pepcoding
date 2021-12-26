package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int sp = n/2;
		int stars = 1;
		int m = 0;
	
		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= sp; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= stars; j++) {
				if (j <= (stars/2+1)) {
					m++;
				} else {
					m--;
				}
				System.out.print(m + "\t");
			}
			System.out.println();
			if (i <= n/2) {
				sp--;
				stars += 2;
			} else {
				sp++;
				stars -= 2;
				m -= 2;
			}
		}
		
		
	}

}
