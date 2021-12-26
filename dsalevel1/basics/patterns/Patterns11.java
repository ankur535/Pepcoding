package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int k = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(k++ + "\t");
			}
			System.out.println();
		}

	}

}
