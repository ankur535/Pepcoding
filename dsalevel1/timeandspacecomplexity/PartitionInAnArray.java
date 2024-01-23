package dsalevel1.timeandspacecomplexity;

import java.util.*;

public class PartitionInAnArray {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int pivot = in.nextInt();
		partition(arr, pivot);
		print(arr);
		in.close();
	}

	/*
	 * 0 -> j-1 ----> smaller area (area with element smaller than pivot) j -> i-1
	 * ----> larger area (area with element larger than pivot) i -> n-1 ----> Unknow
	 * area (area not visited)
	 */
	public static void partition(int[] arr, int pivot) {
		// write your code here
		int i = 0;
		int j = 0;

		while (i < arr.length) {
			if (arr[i] <= pivot) {
				swap(arr, i, j);
				j++; // smaller area increase
				i++; // unknown area decrease
			} else {
				i++; // larger area increase and unknown area decrease.
			}
		}

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
