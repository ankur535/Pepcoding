package dsalevel1.advancedds.hashmapandheap;

import java.util.*;
import java.io.*;

public class KLargestElementsPep {
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

			pq.add(arr[i]);

			//if size is greater than k, remove peek/smallest element
			if (pq.size() > k) {
				pq.remove();
			}
		}
		
		//store k value in arrayList
		ArrayList<Integer> ans = new ArrayList<>();
		while(pq.size() > 0) {
			ans.add(pq.remove());
		}
		
		//print arrayList in reverse for descending order
		for (int i = k-1; i >= 0; i--) {
			System.out.print(ans.get(i) + " ");
		}

	}
}
