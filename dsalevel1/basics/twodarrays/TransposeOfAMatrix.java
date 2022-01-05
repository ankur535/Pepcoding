package dsalevel1.basics.twodarrays;

import java.util.Scanner;

public class TransposeOfAMatrix {

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
		in.close();

		getTranspose(arr);
		
		display(arr);

	}

	public static void getTranspose(int[][] arr) {
		int n = arr.length;
		
		for (int diagonal = 1; diagonal < n; diagonal++) {
			int row = 0;
			int col = diagonal;

			while (col < n) {
				int temp = arr[row][col];
				arr[row][col] = arr[col][row];
				arr[col][row] = temp;
				col++;
				row++;
			}
		}
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
