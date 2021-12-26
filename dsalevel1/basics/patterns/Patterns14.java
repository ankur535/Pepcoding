package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " * " + i + " = " + (n*i) );
		}

	}

}
