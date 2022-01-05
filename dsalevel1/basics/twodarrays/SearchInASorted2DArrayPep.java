package dsalevel1.basics.twodarrays;

import java.util.Scanner;

//Taking benefit of only row sorting
public class SearchInASorted2DArrayPep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		int d = in.nextInt();
		in.close();

		int row = 0;
		int col = n - 1;

		while (col >= 0 && row < n) {

			if (d == arr[row][col]) {
				System.out.println(row);
				System.out.println(col);
				return;
			}
			if (d < arr[row][col]) {
				col--;
			} else if (d > arr[row][col]) {
				row++;
			}
		}

		System.out.println("Not Found");

	}

}
