package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class RotateANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		in.close();

		int temp = n;
		int count = 0; //because after every number length value will repeat.
		while (temp > 0) {
			temp /= 10;
			count++;
		}
		k = k%count;
		if (k<0) {
			k = k + count;
		}
		if (k != 0) {
			int digit = (int) Math.pow(10, k);
			int power = (int) Math.pow(10, count-k);
			int first = n%digit;
			int last = n/digit;
			n = first*power + last;
		}
		System.out.println(n);
	}

}
