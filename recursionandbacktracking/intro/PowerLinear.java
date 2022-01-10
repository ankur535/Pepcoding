package dsalevel1.recursionandbacktracking.intro;

import java.util.Scanner;

public class PowerLinear {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int n = in.nextInt();
		System.out.println(power(x, n));
		in.close();
	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}
		int plml = power(x, n - 1);
		int pl = x * plml;
		return pl;

		/* Or this
		 
		 if (n == 0) {
			return 1;
		}
		return x * power(x, n-1);
		
		 */
		
	}

}
