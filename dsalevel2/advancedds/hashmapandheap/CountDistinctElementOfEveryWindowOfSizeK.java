package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

public class CountDistinctElementOfEveryWindowOfSizeK {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {

			if (i < k) {
				//update or insert key with the frequency if i is less than k
				if (map.containsKey(arr[i])) {
					int old_freq = map.get(arr[i]);
					map.put(arr[i], old_freq + 1);
				} else {
					map.put(arr[i], 1);
				}
			} else {
				//add size to arraylist
				ans.add(map.size());
				
				//add new value to map
				if (map.containsKey(arr[i])) {
					int old_freq = map.get(arr[i]);
					map.put(arr[i], old_freq + 1);
				} else {
					map.put(arr[i], 1);
				}
				
				//index to remove from map
				int rvIndex = i - k;
				int key = arr[rvIndex];
				
				//if freq is 1, remove from map
				if (map.get(key) == 1) {
					map.remove(key);
				} else {
					//else reduce the frequency
					int old_freq = map.get(key);
					map.put(key, old_freq - 1);
				}	
			}
		}
		//add for last value also
		ans.add(map.size());
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr, k);
		for (int a : ans) {
			System.out.print(a + " ");
		}
		scn.close();
	}

}
