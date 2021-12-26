package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class InverseANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		int temp = num;
		int i = 1;
		int sum = 0;
		while (temp != 0) {
			int digit = temp%10;
			temp = temp/10;
			sum += i * (int)Math.pow(10, digit-1);
			i++;
		}
		System.out.println(sum);
	}
}
