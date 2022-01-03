package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class BarChart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		for (int i = 1; i <= max; i++) {
			for (int val : arr) {
				if (val >= (max - i + 1)) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}

	}

}
