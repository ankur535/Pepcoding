package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class CountsDigitsInaNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); 
		int count = 0;
		in.close();
		while (n != 0) {
			n = (int) n/10;
			count++;
		}
		System.out.println(count);
		//or Try System.out.println(Integer.toString(n).length());
	}
}
