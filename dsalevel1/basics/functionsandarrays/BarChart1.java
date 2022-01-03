package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class BarChart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		for (int i = max; i > 0; i--) {
			for (int val : arr) {
				if (val >= i) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}

	}

}
