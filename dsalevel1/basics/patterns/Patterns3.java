package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int sp = n-1;
		int stars = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sp ; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("*\t");
			}
			sp--;
			stars++;
			System.out.println();
		}
	}
}
