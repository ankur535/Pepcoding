package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class PrimeFactorisationOfANumberPep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    in.close();
	    
	    for (int i = 2; i*i <= n; i++) {
			while (n%i == 0) {
				System.out.print(i + " ");
				n = n/i;
			}
		}
	    if (n != 1) {
	    	System.out.print(n);
	    }
	}

}
