package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class BrokenEconomyPep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		int d = in.nextInt();
		in.close();
		int low = 0;
		int high = n - 1;
		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (a[mid] == d) {
				floor = ceil = mid;
			}
			if (a[mid] < d) {
				low = mid + 1;
				floor = a[mid];
			} else if (a[mid] > d) {
				high = mid - 1;
				ceil = a[mid];
			}
		}
		System.out.println(ceil);
		System.out.println(floor);

	}

}
