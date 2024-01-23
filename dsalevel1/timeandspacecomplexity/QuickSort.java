package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		quickSort(arr, 0, arr.length - 1);
		print(arr);
	}

	public static void quickSort(int[] arr, int low, int high) {
		// write your code here

		if (low > high) {
			return;
		}
		
		int j = partition(arr, arr[high], low, high);

		quickSort(arr, low, j-1);
		quickSort(arr, j+1, high);
		
	}

	public static int partition(int[] arr, int pivot, int low, int high) {
		System.out.println("pivot -> " + pivot);
		int i = low, j = low;
		while (i <= high) {
			if (arr[i] <= pivot) {
				swap(arr, i, j);
				i++;
				j++;
			} else {
				i++;
			}
		}
		System.out.println("pivot index -> " + (j - 1));
		return (j - 1);
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
