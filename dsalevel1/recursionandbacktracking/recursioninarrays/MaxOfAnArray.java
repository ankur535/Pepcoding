package dsalevel1.recursionandbacktracking.recursioninarrays;

import java.util.Scanner;

public class MaxOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		System.out.println(maxOfArray(arr, 0));

	}

	public static int maxOfArray(int arr[], int idx) {

		if (idx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int max = maxOfArray(arr, idx + 1);
		if (max < arr[idx]) {
			max = arr[idx];
		}
		return max;

	}

}
