package dsalevel1.basics.twodarrays;

import java.util.Scanner;

public class SaddlePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int a[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = in.nextInt();
			}
		}
		in.close();

		for (int row = 0; row < n; row++) {

			int min = a[row][0];
			int col = 0;

			for (int j = 1; j < n; j++) {
				if (min > a[row][j]) {
					min = a[row][j];
					col = j;
				}
			}

			boolean saddleFlag = true;
			for (int i = 0; i < n; i++) {
				if (min < a[i][col]) {
					saddleFlag = false;
					break;
				}
			}

			if (saddleFlag) {
				System.out.println(min);
				return;
			}
		}

		System.out.println("Invalid input");

	}

}
