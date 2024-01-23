package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class QuickSort2 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		quickSort(arr, 0, arr.length - 1);
		print(arr);
		in.close();
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void quickSort(int[] arr, int low, int high) {
		// write your code here

		if (low > high) {
			return;
		}

		int pivot = findPivot(arr, low, high);

		quickSort(arr, low, pivot - 1);
		quickSort(arr, pivot + 1, high);

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
