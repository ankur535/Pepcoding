package dsalevel1.basics.patterns;

import java.util.Scanner;

public class Patterns18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int sp = n/2;
		int stars = 1;
		int osp = 1;
		int isp = n-4;
		
		for (int i = 1; i <= n/2; i++) {
			if (i==1) {
				for (int j = 1; j <= n; j++) {
					System.out.print("*\t");
				}
			} else {
				for (int j = 1; j <= osp; j++) {
					System.out.print("\t");
				}
				System.out.print("*\t");
				for (int j = 1; j <= isp; j++) {
					System.out.print("\t");
				}
				System.out.print("*\t");
				osp++;
				isp -= 2;
			}
			System.out.println();
		}
		for (int i = (n/2 + 1); i <= n; i++) {
			for (int j = 1; j <= sp; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("*\t");
			}
			System.out.println();
			if (stars >= n) {
				break;
			}
			stars += 2;
			sp--;
		}
	}

}
