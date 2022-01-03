package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class BrokenEconomy {

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
		int floor = -1;
		int ceil = -1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (a[mid] == d) {
				floor = ceil = mid;
			}
			if (a[mid] < d) {
				low = mid + 1;
			} else if (a[mid] > d) {
				high = mid - 1;
			}
		}
		if (floor == -1 && ceil == -1) {
			floor = a[high];
			ceil = a[low];
		}
		System.out.println(ceil);
		System.out.println(floor);

	}

}
