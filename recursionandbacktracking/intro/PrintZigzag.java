package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class PrintZigzag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		pzz(n);
		
	}

	public static void pzz(int n) {
		
		if (n == 0) {
			return;
		}
		//pre
		System.out.print(n + " ");
		pzz(n-1);
		//In
		System.out.print(n + " ");
		pzz(n-1);
		//post
		System.out.print(n + " ");
	}

}
