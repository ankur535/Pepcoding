package dsalevel2.basics.arraysandstrings;

import java.util.Scanner;

public class MaxConsecutiveOnesPart3 {

	// Leetcode 1004. Max Consecutive Ones III
	public static int longestOnes(int[] nums, int k) {
		// write your code here

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
			while (count > k) {
				// bring back window within k
				if (nums[si] == 0) {
					count--;
				}
				si++;
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
		int k = scn.nextInt();
		System.out.println(longestOnes(arr, k));
		scn.close();
	}

}
