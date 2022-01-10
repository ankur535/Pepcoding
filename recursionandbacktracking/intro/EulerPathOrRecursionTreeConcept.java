package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class EulerPathOrRecursionTreeConcept {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printStack(n);
		in.close();
	}

	private static void printStack(int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			return;
		}
		
		System.out.println("Pre " + n);
		printStack(n-1);
		System.out.println("In " + n);
		printStack(n-1);
		System.out.println("Post " + n);
		
	}
}
