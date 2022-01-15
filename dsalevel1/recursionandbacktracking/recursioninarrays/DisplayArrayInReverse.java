package dsalevel1.recursionandbacktracking.recursioninarrays;

import java.util.Scanner;

public class DisplayArrayInReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		displayArrReverse(arr, 0);
		
	}
	
	public static void displayArrReverse(int arr[], int idx) {
		
		if (idx == arr.length) {
			return;
		}
		
		displayArrReverse(arr, idx+1);
		System.out.println(arr[idx]);
	}

}
