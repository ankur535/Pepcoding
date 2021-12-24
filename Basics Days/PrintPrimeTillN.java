package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class PrintPrimeTillN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int low = in.nextInt();
		int high = in.nextInt();
		int num = 0;
		in.close();
		for (int i = low; i <= high; i++) {
			num = findPrime(i);
			if (num != 0) {
				System.out.println(num);
			}
		}
	}

	public static int findPrime(int num) {
		for (int j = 2; j * j <= num; j++) {
			if (num % j == 0) {
				return 0;
			}
		}
		return num;
	}

}
