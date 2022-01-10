package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		in.close();
		toh(n, A, B, C);
	}
	
	public static void toh(int n, int A, int B, int C) {
		
		if (n == 0) {
			return;
		}
		
		toh(n-1, A, C, B);
		System.out.println(n + "[" + A + " -> " + B + "]");
		toh(n-1, C, B, A);
		
	}

}
