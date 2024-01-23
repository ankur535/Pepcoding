package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		countSort(arr, min, max);
		print(arr);
		scn.close();
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void countSort(int[] arr, int min, int max) {

		int range = max - min + 1;
		int[] farr = new int[range];

		//frequency array
		for (int i = 0; i < arr.length; i++) {
			farr[arr[i] - min]++;
		}

		//converting to prefix sum array
		for (int j = 1; j < farr.length; j++) {
			farr[j] += farr[j - 1];
		}

		int ans[] = new int[arr.length];

		//Updating new array from last to maintain Stable Sort
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = farr[arr[i] - min] - 1;
			ans[pos] = arr[i];
			farr[arr[i] - min]--;
		}

		for (int i = 0; i < ans.length; i++) {
			arr[i] = ans[i];
		}

	}

}
