package dsalevel2.basicsds.stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElementII {
	public static int[] nextGreaterElementII(int[] nums) {

		int n = nums.length;
		Stack<Integer> st = new Stack<Integer>();
		int ngr[] = new int[n];

		// Visit all the values except last once in reverse to fill the stack with the
		// greater values in order
		for (int i = n - 2; i >= 0; i--) {
			while (!st.isEmpty() && nums[i] >= st.peek()) {
				st.pop();
			}
			st.push(nums[i]);
		}

		// No do the usual Next Greater to Right using the above stack
		for (int i = n - 1; i >= 0; i--) {

			int val = nums[i];
			while (!st.isEmpty() && val >= st.peek()) {
				st.pop();
			}

			ngr[i] = st.isEmpty() ? -1 : st.peek();

			st.push(nums[i]);
		}

		return ngr;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(read.readLine());
		}

		int ans[] = nextGreaterElementII(nums);

		n = ans.length;

		System.out.println(n);
		for (int e : ans) {
			System.out.println(e);
		}

	}
}
