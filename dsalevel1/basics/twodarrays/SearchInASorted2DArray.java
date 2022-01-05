package dsalevel1.basics.twodarrays;

import java.util.Scanner;

//Taking benefit of only row sorting
public class SearchInASorted2DArray {

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

		boolean flag = false;
		for (int row = 0; row < n; row++) {
			int cmin = 0;
			int cmax = n - 1;
			if (d >= arr[row][cmin] && d <= arr[row][cmax]) {
				flag = binarySearch(arr, row, d);
				if (flag) {
					return;
				}
			}
		}

		System.out.println("Not Found");

	}

	public static boolean binarySearch(int arr[][], int row, int d) {

		int n = arr.length;
		int low = 0;
		int high = n - 1;
		int ans = Integer.MAX_VALUE;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[row][mid] == d) {
				ans = mid;
				break;
			}
			if (arr[row][mid] < d) {
				low = mid + 1;
			} else if (arr[row][mid] > d) {
				high = mid - 1;
			}
		}

		if (ans != Integer.MAX_VALUE) {
			System.out.println(row);
			System.out.println(ans);
			return true;
		}
		return false;
	}

}
