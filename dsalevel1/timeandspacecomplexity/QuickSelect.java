package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class QuickSelect {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		int p = quickSelect(arr, 0, arr.length - 1, k-1);
		//k-1 for kth minimum
		//n-k for kth largest
		System.out.println(arr[p]);
		scn.close();
	}

	public static int quickSelect(int[] arr, int low, int high, int k) {

		if (low > high)
			return -1;

		int pivot = findPivot(arr, low, high);

		if (pivot < k) {
			pivot = quickSelect(arr, pivot + 1, high, k);
		} else if (pivot > k) {
			pivot = quickSelect(arr, pivot + 1, high, k);
		}

		return pivot;
	}

	public static int findPivot(int[] arr, int low, int high) {

		int i = low + 1;
		int j = high;

		while (i <= j) {

			while (i <= j && arr[i] < arr[low]) {
				i++;
			}

			while (arr[j] > arr[low]) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		int temp = arr[j];
		arr[j] = arr[low];
		arr[low] = temp;

		return j;

	}
}
