package dsalevel1.basics.functionsandarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateAnArray {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int k = Integer.parseInt(br.readLine());

		rotate(a, k);
		display(a);
		br.close();
	}

	public static void display(int[] a) {
		StringBuilder sb = new StringBuilder();

		for (int val : a) {
			sb.append(val + " ");
		}
		System.out.println(sb);
	}

	public static void rotate(int[] a, int k) {
		// write your code here
		int n = a.length;
		k = k % n;
		if (k < 0) {
			k = k + n;
		}

		// reverse a
		reverse(a, 0, n-k-1);
		// reverse b
		reverse(a, n-k, n-1);
		// reverse total
		reverse(a, 0, n-1);
	}

	public static void reverse(int a[], int i, int j) {
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}

	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
