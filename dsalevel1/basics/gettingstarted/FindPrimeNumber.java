package dsalevel1.basics.gettingstarted;

import java.util.ArrayList;
import java.util.Scanner;

public class FindPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Integer t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			arrList.add(i, scn.nextInt());
		}
		for (Integer num : arrList) {
			printPrime(num);
		}

		scn.close();
	}

	public static void printPrime(Integer num) {

		for (int j = 2; j*j<= num; j++) {
			if ((num % j) == 0) {
				System.out.println("not prime");
				return;
			}
		}
		System.out.println("prime");
	}
}
