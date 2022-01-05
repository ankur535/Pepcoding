package dsalevel1.basics.twodarrays;

import java.util.Scanner;

public class TheStateOfWakanda2 {

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

		for (int diagonal = 0; diagonal < n; diagonal++) {
			int row = 0;
			int col = diagonal;
			while (col < n) {
				System.out.println(a[row][col]);
				row++;
				col++;
			}
		}
		
		/* or This can be done
		 
		 int diagonal = 0;

		while (diagonal < n) {

			int row = 0;
			int col = diagonal;

			while (col < n) {
				System.out.println(a[row][col]);
				row++;
				col++;
			}
			diagonal++;
		}
		 
		 */

	}

}
