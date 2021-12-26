package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class DigitsofaNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int temp = n;
		int power = 1;
		while (temp >= 10) {
			temp /= 10;
			power *= 10;
		}
		temp = n;
		while (power != 0) {
			int digit = temp / power;
			System.out.println(digit);
			
			temp = temp % power;
			power /= 10;
		}
	}
}
