package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class PrintIncreasingDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		pdi(n);
		in.close();
	}

	public static void pdi(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		pdi(n - 1);
		System.out.println(n);

	}

}
