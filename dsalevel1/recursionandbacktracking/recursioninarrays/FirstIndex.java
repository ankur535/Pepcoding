package dsalevel1.recursionandbacktracking.recursioninarrays;

import java.util.Scanner;

public class FirstIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int x = in.nextInt();
		in.close();
		System.out.println(firstIndex(arr, 0, x));
		
	}

	public static int firstIndex(int arr[], int idx, int x) {

		if (idx == arr.length) {
			return -1;
		}
		
		// pre index check
		if (x == arr[idx]) {
			return idx;
		}
		int idxp1 = firstIndex(arr, idx + 1, x);
		
		/* Uncomment this and comment pre index check for reverse array condition
		 
		// post index check
		if (x == arr[idx]) {
			return idx;
		}
		
		*/
		
		return idxp1;

	}

}
