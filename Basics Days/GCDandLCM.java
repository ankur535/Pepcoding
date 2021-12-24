package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class GCDandLCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		in.close();
		int divisor = num1;
		int divident = num2;
		if (divisor == 0 || divident == 0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}
		while (divisor != 0) {
			int rem = divident%divisor;
			divident = divisor;
			divisor = rem;
		}
		int gcd = divident;
		int lcm = (num1*num2)/gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}

}
