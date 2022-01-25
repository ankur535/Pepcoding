package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int m = in.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
		}
		int[] mergedArray = mergeTwoSortedArrays(a, b);
		print(mergedArray);
		in.close();
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
		// write your code here
		int n = a.length;
		int m = b.length;
		int i = 0;
		int j = 0;

		int ans[] = new int[n + m];

		for (int k = 0; k < ans.length; k++) {

			if (j == m) {
				ans[k] = a[i];
				i++;
				continue;
			}

			if (i == n) {
				ans[k] = b[j];
				j++;
				continue;
			}

			if (a[i] < b[j]) {
				ans[k] = a[i];
				i++;
			} else {
				ans[k] = b[j];
				j++;
			}

		}
		return ans;
	}

}
