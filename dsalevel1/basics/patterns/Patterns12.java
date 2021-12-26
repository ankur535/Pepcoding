package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int a = 0;
		int b = 1;
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(a + "\t");
				sum = a+b;
				a = b;
				b = sum;
			}
			System.out.println();
		}

	}

}
