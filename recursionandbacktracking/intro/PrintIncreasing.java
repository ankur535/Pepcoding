package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class PrintIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printIncreasing(n);
		in.close();
	}
	
	public static void printIncreasing(int n) {
		if (n == 0) {
			return;
		}
		//recursive call
		printIncreasing(n-1);
		//Self work
		System.out.println(n);
	}

}
