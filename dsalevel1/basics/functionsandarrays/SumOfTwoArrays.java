package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class SumOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int arr1[] = new int[n1];
		for (int i = 0; i < n1; i++) {
			arr1[i] = in.nextInt();
		}
		int n2 = in.nextInt();
		int arr2[] = new int[n2];
		for (int i = 0; i < n2; i++) {
			arr2[i] = in.nextInt();
		}
		in.close();
		printSum(n1, arr1, n2, arr2);

	}

	public static void printSum(int n1, int arr1[], int n2, int arr2[]) {

		int i = n1 - 1;
		int j = n2 - 1;

		int sum[] = new int[n1 > n2 ? n1 : n2];
		int k = sum.length - 1;

		int carry = 0;
		while (i >= 0 || j >= 0) {

			int d = carry;

			if (i >= 0) {
				d += arr1[i];
			}
			if (j >= 0) {
				d += arr2[j];
			}

			carry = d / 10;
			d = d % 10;

			sum[k] = d;

			i--;
			j--;
			k--;
		}
		
		if (carry > 0) {
			System.out.println(carry);
		}
		for (int val : sum) {
			System.out.println(val);
		}
	}

}
