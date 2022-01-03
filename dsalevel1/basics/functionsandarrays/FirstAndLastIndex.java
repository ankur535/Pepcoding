package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class FirstAndLastIndex {

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

		int firstIndex = findFirstIndex(a, d);
		int lastIndex = findLastIndex(a, d);
		System.out.println(firstIndex);
		System.out.println(lastIndex);
	}

	public static int findFirstIndex(int[] a, int d) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = a.length - 1;
		int ans = -1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (a[mid] == d) {
				ans = mid;
				high = mid - 1;
			} else if (a[mid] < d) {
				low = mid + 1;
			} else if (a[mid] > d) {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static int findLastIndex(int[] a, int d) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = a.length - 1;
		int ans = -1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (a[mid] == d) {
				ans = mid;
				low = mid + 1;
			} else if (a[mid] < d) {
				low = mid + 1;
			} else if (a[mid] > d) {
				high = mid - 1;
			}
		}
		return ans;
	}

}
