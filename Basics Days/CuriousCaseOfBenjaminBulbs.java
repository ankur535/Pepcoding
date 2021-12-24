package dsalevel1.basics.gettingstarted;

import java.util.Scanner;

public class CuriousCaseOfBenjaminBulbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for (int i = 1; i*i <= n; i++) {
			System.out.println(i * i);
		}
		
	}

}
