package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class SpanOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int max = arr[0];
		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		int span = max - min;
		System.out.println(span);
		in.close();
	}

}
