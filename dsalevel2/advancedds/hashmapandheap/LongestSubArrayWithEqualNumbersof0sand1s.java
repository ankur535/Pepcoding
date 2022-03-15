package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

//Leetcode 525 Contiguous Array
public class LongestSubArrayWithEqualNumbersof0sand1s {

	public static int solution(int[] arr) {
		// write your code here
		//Converting all Zeroes to -1
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		
		//Simple, find longest subarray with sum 0
		HashMap<Integer, Integer> map = new HashMap<>();

		int ans = 0;
		int csum = 0;

		map.put(csum, -1);

		for (int i = 0; i < arr.length; i++) {
			//add in csum 
			csum += arr[i];

			if (map.containsKey(csum)) {
				//if exist in map, find length of new subarray
				int len = i - map.get(csum);
				ans = Math.max(ans, len);
			} else {
				//insert csum with index of arr element
				map.put(csum, i);
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
