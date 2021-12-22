package basics.days;

import java.util.Scanner;

public class FindPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		boolean flag = true;
		for (int i = 0; i < t; i++) {
			int num = in.nextInt();
			flag = true;
			for (int j = 2; j*j <= num; j++) {
				if (num%j == 0) {
					flag = false;
					System.out.println("not prime");
					break;
				}
			}
			if (flag) {
				System.out.println("prime");
			}	
		}
		in.close();
	}
}
