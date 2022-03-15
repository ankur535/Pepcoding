package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

//LeetCode - 560
public class CountOfSubArraysHavingSumEqualsToK {

	public static int subarraySum(int[] nums, int k) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		int count = 0;
		int csum = 0;
		//inital csum in map with freq 1
		map.put(csum, 1);

		for (int i = 0; i < nums.length; i++) {

			csum += nums[i];
			//finding x as (y - k) or ((x + k )- k))
			int x = csum - k;

			//if map conatains x, add its freq to count
			if (map.containsKey(x)) {
				count += map.get(x);
			}
			
			//if value/freq exist, increase by 1 else add new entry with freq 0+1 = 1
			map.put(csum, map.getOrDefault(csum, 0) + 1);
		}

		return count;
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.println(subarraySum(arr, k));
		scn.close();
	}

}
