package dsalevel1.basics.gettingstarted;

import java.util.Iterator;
import java.util.Scanner;

public class MaxMin2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		int a = 0, b = 0;
		int max = arr[0];
		int min = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			
			if (max < arr[i]) {
				if (a != 2) {
					max = arr[i];
					a++;
				}
			}
			if (min > arr[i]) {
				if (b != 2) {
					max = arr[i];
					b++;
				}
			}
		}
	}
}
