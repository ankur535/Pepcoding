package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns19Pep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				
				if ((i <= n/2 && j == n) || (i > (n/2 + 1) && j == 1)) {
					System.out.print("*\t");
				} else if (i == (n/2+1) || j == (n/2+1)) {
					System.out.print("*\t");
				} else if ((i == 1 && j <= n/2) || (i == n && j > n/2+1)) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

}
