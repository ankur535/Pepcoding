package dsalevel1.timeandspacecomplexity;

import java.util.Scanner;

public class MergeTwoSortedArrayPep {

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

	public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
		// write your code here
		int n = a.length;
		int m = b.length;
		int ans[] = new int[n + m];

		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i<n && j<m) {
			if(a[i] < b[j]) {
				ans[k] = a[i];
				i++;
			} else {
				ans[k] = b[j];
				j++;
			}
			k++;
		}
		
		while (j<m) {
			ans[k] = b[j];
			j++;
			k++;
		}
		
		while (i<n) {
			ans[k] = a[i];
			i++;
			k++;
		}
		return ans;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
