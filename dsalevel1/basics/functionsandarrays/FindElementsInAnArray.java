package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class FindElementsInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		int d = in.nextInt();
		in.close();
		
		for (int i = 0; i < arr.length; i++) {
			if (d == arr[i]) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);
	}

}
