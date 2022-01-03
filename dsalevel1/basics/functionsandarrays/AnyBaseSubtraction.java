package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class AnyBaseSubtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int b = scn.nextInt();
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		scn.close();
		int d = getDifference(b, n1, n2);
		System.out.println(d);
	}

	public static int getDifference(int b, int n1, int n2) {
		// write you code here
		int val1 = getValueInDecimal(n1, b);
		int val2 = getValueInDecimal(n2, b);
		int res = getValueInBase(val2-val1, b);
		return res;
	}

	private static int getValueInDecimal(int n, int b) {

		int val = 0;
		int pow = 0;
		while (n > 0) {
			int rem = n % 10;
			val = val + rem * (int) Math.pow(b, pow);
			pow++;
			n = n / 10;
		}
		return val;
	}
	
	private static int getValueInBase(int n, int b) {
		
		int val = 0;
		int pow10 = 1; 
		while (n > 0) {
			int rem = n % b;
			val = val + rem * pow10;
			pow10 = pow10 * 10;
			n = n / b;
		}
		return val;
	}
	  
	   

}
