package basics.days;

import java.util.Scanner;

public class GradingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int marks = scn.nextInt();
		scn.close();
		if (marks>90) {
			System.out.println("excellent");
		} else if (marks>80) {
			System.err.println("good");
		} else if (marks>70) {
			System.out.println("fair");
		} else if (marks>60) {
			System.out.println("meets expectations");
		} else {
			System.out.println("below par");
		}
		
	}

}
