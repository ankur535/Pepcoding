package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		in.close();
		
		int max = a;
		if(b >= max) {
			max = b;
		} 
		if (c >= max) {
			max = c;
		} 
		
		if (max == a) {
			System.out.println((b*b + c*c) == (a*a));
		} else if (max == b) {
			System.out.println((a*a + c*c) == (b*b));
		} else if (max == c) {
			System.out.println((b*b + a*a) == (c*c));
		}	
	}
}
