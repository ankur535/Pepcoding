package dsalevel2.basics.arraysandstrings;

import java.util.Scanner;

public class MaxConsecutiveOnesPart1 {

	// Leetcode 485. Max Consecutive Ones
	public static int findMaxConsecutiveOnes(int[] nums) {
		int si = 0;
		int ei = 0;

		int ans = 0;
		// keeps count of Zeroes
		int count = 0;
		int n = nums.length;

		// loop till last of array
		while (ei < n) {

			// if nums is 0, increase count
			if (nums[ei] == 0) {
				count++;
			}

			// go further always
			ei++;

			// if window is crossed for k
			while (count > 0) {
				// bring back window as just crossed 0
				si = ei;
				count--;
			}

			// update and everytime for each index
			int len = ei - si;
			ans = Math.max(ans, len);
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(findMaxConsecutiveOnes(arr));
		scn.close();
	}

}
