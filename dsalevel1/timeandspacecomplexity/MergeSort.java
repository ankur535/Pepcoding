package dsalevel1.timeandspacecomplexity;

import java.util.*;

public class MergeSort {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		int[] sa = mergeSort(arr, 0, arr.length - 1);
		System.out.print("Sorted Array -> ");
		print(sa);
	}

	public static int[] mergeSort(int[] arr, int low, int high) {
		// write your code here
		if (low == high) {
			int ab[] = new int[1];
			ab[0] = arr[low];
			return ab;
		}
		
		int mid = (low + high)/2;
		
		int a[] = mergeSort(arr, low, mid);
		int b[] = mergeSort(arr, mid+1, high);
		
		int ans[] = mergeTwoSortedArrays(a, b);

		return ans;
	}

	// used for merging two sorted arrays
	public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
		System.out.println("Merging these two arrays ");
		System.out.print("left array -> ");
		print(a);
		System.out.print("right array -> ");
		print(b);
		int i = 0, j = 0, k = 0;
		int[] ans = new int[a.length + b.length];
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				ans[k] = a[i];
				i++;
				k++;
			} else {
				ans[k] = b[j];
				j++;
				k++;
			}
		}

		while (i < a.length) {
			ans[k] = a[i];
			k++;
			i++;
		}

		while (j < b.length) {
			ans[k] = b[j];
			k++;
			j++;
		}

		return ans;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
