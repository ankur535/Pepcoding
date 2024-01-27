package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class Sort01 {

	public static void sort01(int[] arr) {
		// write your code here
		int i = 0;
		int j = 0;

		//Using Partition an Array technique
		//i -> n-1 [unexplored area]
		//0 -> j-1 [0]
		//j -> i-1 [1]
		while (i < arr.length) {

			if (arr[i] == 0) {
				swap(arr, i, j);
				i++;
				j++;
			} else {
				i++;
			}
		}
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		// System.out.println("Swapping index " + i + " and index " + j);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		scn.close();
		sort01(arr);
		print(arr);
	}

}