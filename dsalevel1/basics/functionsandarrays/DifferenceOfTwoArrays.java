package dsalevel1.basics.functionsandarrays;

import java.util.Scanner;

public class DifferenceOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n1 = in.nextInt();
		int arr1[] = new int[n1];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = in.nextInt();
		}
		int n2 = in.nextInt();
		int arr2[] = new int[n2];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = in.nextInt();
		}
		int diff[] = getDifference(arr1, arr2);
		printArray(diff);
		in.close();
	}

	public static int[] getDifference(int arr1[], int arr2[]) {

		int carry = 0;
		int i = arr1.length - 1;
		int j = arr2.length - 1;
		int diff[] = new int[arr2.length];
		int k = diff.length - 1;

		while (j >= 0) {

			int d = carry;
			d = arr2[j] - d;
			if (i >= 0) {
				d = d - arr1[i];
			}

			if (d < 0) {
				d = d + 10;
				carry = 1;
			} else {
				carry = 0;
			}
			diff[k] = d;
			
			i--;
			j--;
			k--;
		}
		return diff;

	}

	public static void printArray(int arr[]) {
		
		int index = 0;
		while (arr[index] == 0) {
			index++;
		}
		
		for (int i = index; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
