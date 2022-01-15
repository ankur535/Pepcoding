package dsalevel1.recursionandbacktracking.recursioninarrays;

import java.util.Scanner;

public class DisplayArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		displayArr(arr, 0);

	}

	public static void displayArr(int arr[], int idx) {

		if (idx == arr.length) {
			return;
		}

		System.out.println(arr[idx]);
		displayArr(arr, idx + 1);

	}

}
