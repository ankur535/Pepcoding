package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int sp = 1;
		
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j < sp; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*\t");
			}
			sp++;	
			System.out.println();
		}
	}
}
