package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class SortDates {

	public static void sortDates(String[] arr) {
		// write your code here

		countSort(arr, 1000000, 100, 32); // days
		countSort(arr, 10000, 100, 13); // months
		countSort(arr, 1, 1000, 2501); // years
	}

	public static void countSort(String[] arr, int div, int mod, int range) {
		// write your code here
		int farr[] = new int[range];

		// frequency array
		//Integer.parseInt(arr[i], 10), 10 states to use decimal conversion
		//otherwise for values like 06 it might consider octal value
		for (int i = 0; i < arr.length; i++) {
			farr[Integer.parseInt(arr[i], 10) / div % mod]++;
		}

		// prefix sum array
		for (int i = 1; i < farr.length; i++) {
			farr[i] += farr[i - 1];
		}

		String[] ans = new String[arr.length];

		// new sorted array
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = farr[Integer.parseInt(arr[i], 10) / div % mod] - 1;
			ans[pos] = arr[i];
			farr[Integer.parseInt(arr[i]) / div % mod]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}

	}

	public static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			arr[i] = str;
		}
		scn.close();
		sortDates(arr);
		print(arr);
	}

}
