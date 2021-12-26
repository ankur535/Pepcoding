package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for (int i = 1; i <= n; i++) {
			int num = in.nextInt();
			int count = 0;
			Long sum = 0L;
			int swap = 1;
			for (int j = 1; j <= num; j++) {
				int digit = in.nextInt();
				if (digit == 9 && swap != 0) {
					sum = digit*(int)Math.pow(10, count) + sum;
					swap = 0;
				} else {
					sum = sum * (int)Math.pow(10, 1) + digit;
				}
				count++;
			}
			System.out.println(sum);
		} 
		
		in.close();
		
	}

}
