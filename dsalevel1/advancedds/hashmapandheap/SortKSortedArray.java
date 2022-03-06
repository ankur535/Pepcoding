package dsalevel1.advancedds.hashmapandheap;

import java.io.*;
import java.util.*;

public class SortKSortedArray {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int k = Integer.parseInt(br.readLine());
		// write your code here

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {

			pq.add(arr[i]);
			
			//if pq size greater than k, remove 1 element
			//to maintain maximum k size
			if (pq.size() > k) {
				System.out.println(pq.remove());
			}
		}

		//print remaining pq elements in sorted manner
		while (pq.size() > 0) {
			System.out.println(pq.remove());
		}
	}
}