package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class PrimeFactorisationOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		int temp = num;
		boolean count = true;
		for (int i = 2; i <= num;) {
			if (temp%i == 0) {
				count = false;
				System.out.print(i + " ");
				temp = temp/i;
			} else {
				i++;
			}
		}
		if (count) {
			System.out.println(num);
		}
	}

}
