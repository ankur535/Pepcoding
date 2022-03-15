package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

//Geeks and Pep
public class LongestSubArrayWithSumDivisibleByK {

    public static int solution(int[] arr, int k) {
        // write your code here
    	
    	// We can use array also, as remainder is limited to k only
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	int ans = 0;
    	int csum = 0;
    	
    	//initial index for csum 0
    	map.put(csum, -1);
    	
    	for (int i = 0; i < arr.length; i++) {
    		//add in csum, csum is c
    		csum += arr[i];
    		
    		//find rem for csum which is a
    		int rem = csum % k;
    		
    		if (rem < 0) {
    			rem += k;
    		}
    		
    		if (map.containsKey(rem)) {
    			//if map consist, means len denotes elements of b
        		int idx = map.get(rem);
        		//b is (c - a) elements, Also b will be divisible by k
        		int len = i - idx;
        		
        		//take longest subarray divisible by k, means longest b
        		ans = Math.max(ans, len);
        	} else {
        		//else put remainder with index of element
        		map.put(rem, i);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
        scn.close();
    }

}
