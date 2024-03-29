package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class PivotOfSortedAndRotatedArray {

	public static int findPivot(int[] arr) {
		// write your code here

		int low = 0;
		int high = arr.length - 1;

		int min = Integer.MAX_VALUE;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] > arr[high]) {
				min = Math.min(min, arr[high]);
				low = mid + 1;
			} else {
				min = Math.min(min, arr[mid]);
				high = mid - 1;
			}
		}

		return min;

	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int pivot = findPivot(arr);
		System.out.println(pivot);
		scn.close();
	}

}
