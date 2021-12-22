package basics.days;

import java.util.Scanner;

public class PrintPrimeTillN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int low = in.nextInt();
		int high = in.nextInt();
		in.close();
		for (int i = low; i <= high; i++) {
			boolean flag = true;
			for (int j = 2; j*j <= i; j++) {
				if (i%j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println(i);
			}		
		}			
	}
}
