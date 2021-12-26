package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		int osp = n/2;
		int isp = -1;
		
		for (int i = 1; i <= n; i++) {
			//outer space
			for (int j = 1; j <= osp; j++) {
				System.out.print("\t");
			}
			//stars
			System.out.print("*\t");
			//inner space
			for (int j = 1; j <= isp; j++) {
				System.out.print("\t");
			}
			if (i != 1 && i != n) {
				//second star
				System.out.print("*\t");
			}
			System.out.println();
			if (i <= n/2) {
				osp--;
				isp += 2;
			} else {
				osp++;
				isp -= 2;
			}
		}
		
		
		
		
	}

}
