package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

public class LargestSubArrayWithZeroSum {

	public static int solution(int[] arr) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		int ans = 0;
		int csum = 0;
		//initial put 0 with -1 to handle some test cases
		map.put(csum, -1);

		for (int i = 0; i < arr.length; i++) {

			//add to current sum 
			csum += arr[i];

			//if csum already exist, means in between sum became 0
			if (map.containsKey(csum)) {
				//find initial index of csum
				int idx = map.get(csum);
				//subtract with current index
				int len = i - idx;
				//and store max of ans or len to ans
				ans = Math.max(ans, len);
			} else {
				//else put csum with it current/initial index to map
				map.put(csum, i);
			}
		}
		
		return ans;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}

}
