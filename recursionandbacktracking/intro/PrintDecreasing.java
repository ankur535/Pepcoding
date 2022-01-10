package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class PrintDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printDecreasing(n);
		in.close();
	}
	
	public static void printDecreasing(int n) {
		//Base case
		if (n == 0) {
			return;
		}
		//Self work
		System.out.println(n);
		//Recursive call
		printDecreasing(n-1);
	}

}
