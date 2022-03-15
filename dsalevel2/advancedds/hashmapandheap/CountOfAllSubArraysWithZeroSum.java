package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

public class CountOfAllSubArraysWithZeroSum {

	public static int solution(int[] arr) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		int ans = 0;
		int csum = 0;
		//storing initial frequency as 1 for csum = 0
		map.put(csum, 1);

		for (int i = 0; i < arr.length; i++) {

			csum += arr[i];

			if (map.containsKey(csum)) {
				//find old freq and add to count
				int old_freq = map.get(csum);
				ans += old_freq;
				//increase freq for csum element
				map.put(csum, old_freq + 1);
			} else {
				//else put 1 as new frequency
				map.put(csum, 1);
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}

}
