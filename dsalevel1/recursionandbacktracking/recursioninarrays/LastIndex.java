package dsalevel1.recursionandbacktracking.recursioninarrays;

import java.util.Scanner;

public class LastIndex {

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
		System.out.println(lastIndex(arr, 0, x));
	}
	
	public static int lastIndex(int arr[], int idx, int x) {
		
		if (idx == arr.length) {
			return -1;
		}
		
		int idxp1 = lastIndex(arr, idx+1, x);
		if (arr[idx] == x && idxp1 == -1) {
			return idx;
		}
		return idxp1;
		
	}

}
