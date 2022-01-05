package dsalevel1.basics.twodarrays;

import java.util.Scanner;

public class TheStateOfWakanda1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int a[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = in.nextInt();
			}
		}
		in.close();
		for (int j = 0; j < m; j++) {

			if (j % 2 == 0) {
				for (int i = 0; i < n; i++) {
					System.out.println(a[i][j]);
				}
			} else {
				for (int i = n - 1; i >= 0; i--) {
					System.out.println(a[i][j]);
				}
			}

		}

	}

}
