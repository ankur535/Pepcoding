package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class ReverseaNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		
		while (num!= 0) {
			int val = num%10;
			num /= 10;
			System.out.println(val);
		}
	}
}
