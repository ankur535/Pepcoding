package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

//LeetCode 974. Subarray Sums Divisible by K
public class CountOfSubArraySumsDivisibleByK {

	public static int solution(int[] arr, int k) {
		// write your code here
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int csum = 0;
		int count = 0;
		
		//initial freq as 1
		map.put(csum, 1);
		
		for (int i = 0; i < arr.length; i++) {
			
			csum += arr[i];
			
			//find remainder
			int rem = csum % k;
			
			if (rem < 0) {
				rem += k;
			}
			
			if (map.containsKey(rem)) {
				//if raminder exist, add is freq to count
				int remCount = map.get(rem);
				count += remCount;
				//update remainder freq by 1
				map.put(rem, remCount + 1);
			} else {
				//new remainder value with freq 1
				map.put(rem, 1);
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
		int k = scn.nextInt();
		System.out.println(solution(arr, k));
		scn.close();
	}

}
