package dsalevel2.advancedds.hashmapandheap;

import java.util.*;

//LeetCode 974. Subarray Sums Divisible by K
public class CountOfSubArraySumsDivisibleByKUsingArray {

	public static int solution(int[] arr, int k) {
		// write your code here
		
		int fre[] = new int[k];
		
		int ans = 0;
		int csum = 0;
		
		//setting initial rem 0 count to 1
		fre[csum]++;
		
		for (int i = 0; i < arr.length; i++) {
			
			csum += arr[i];
			
			int rem = csum % k;
			
			if (rem < 0) {
				rem += k;
			}
			
			//if remainder came previously, than add its count value to ans
			if (fre[rem] != 0) {
				ans += fre[rem];
			}
			
			//increase freq of rem always for array
			fre[rem]++;
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
