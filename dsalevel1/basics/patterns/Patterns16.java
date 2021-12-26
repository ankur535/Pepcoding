package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int count = 2*n -3;
		
		int val = 1;
		int stars = 1;
		
		for (int i = 1; i <= n; i++) {
			int num = val;
			for (int j = 1; j <= stars; j++) {
				System.out.print(num + "\t");
				num++;
			}
			for (int j = 1; j <= count; j++) {
				System.out.print("\t");
			}
			if (i == n) {
				stars--;
				num--;
			}
			for (int j = 1; j <= stars; j++) {
				num--;
				System.out.print(num + "\t");
			}
			System.out.println();
			stars++;
			count -= 2;
		}
		
	}

}
