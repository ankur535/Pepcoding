package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

public class CountOfSubarraysWithEqualNumberOf0sand1s {

	public static int solution(int[] arr) {
        // write your code here
		//convert all 0s to -1
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == 0) {
    			arr[i] = -1;
    		}
    	}
    	
    	//Simply calling count all subarrays with sum equals to 0
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	int count = 0;
    	int csum = 0;
    	
    	map.put(csum, 1);
    	
    	for (int i = 0; i < arr.length; i++) {
    		
    		csum += arr[i];
    		
    		if (map.containsKey(csum)) {
    			//if exist in map, add freq to count and increase by 1
    			int old_freq = map.get(csum);
    			count += old_freq;
    			map.put(csum, old_freq + 1);
    		} else {
    			map.put(csum, 1);
    		}
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
		System.out.println(solution(arr));
		scn.close();
	}

}
