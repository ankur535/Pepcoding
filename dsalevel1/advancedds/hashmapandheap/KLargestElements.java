package dsalevel1.advancedds.hashmapandheap;

import java.util.*;
import java.io.*;

public class KLargestElements {
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solve(n, num, k);
		scn.close();
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array,n length of array and k.
	// It should print required output.
	public static void solve(int n, int[] arr, int k) {
		// Write your code here

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {

			int val = arr[i];

			//if size is less than k
			if (pq.size() < k) {
				pq.add(val);
			} else {
				//else if peek is less than new value, remove it and new value
				if (pq.peek() < val) {
					pq.remove();
					pq.add(val);
				}
			}
		}
		
		//store k value in array
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = pq.remove();
		}
		
		//print array in reverse for descending order
		for (int i = k-1; i >= 0; i--) {
			System.out.print(ans[i] + " ");
		}

	}
}
