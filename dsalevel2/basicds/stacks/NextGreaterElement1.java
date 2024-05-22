package dsalevel2.basicsds.stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
	public static int[] nextGreaterElement(int[] nums, int[] query) {
		Stack<Integer> st = new Stack<>();
		HashMap<Integer, Integer> hm = new HashMap<>();

		st.push(nums[nums.length - 1]);
		hm.put(nums[nums.length - 1], -1);

		//Doing Next Greater to Right and Storing in key value pair in hashmap
		for (int i = nums.length - 2; i >= 0; i--) {

			int val = nums[i];

			while (!st.isEmpty() && val >= st.peek()) {
				st.pop();
			}

			if (st.isEmpty()) {
				hm.put(nums[i], -1);
			} else {
				hm.put(nums[i], st.peek());
			}
			st.push(nums[i]);
		}

		//iterating over nums2 and retrieving the hashmap values
		int ans[] = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			ans[i] = hm.get(query[i]);
		}

		return ans;
	}

	public static int[] getArr(String s) {
		String nums[] = s.split(" ");
		int n = nums.length;
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(nums[i]);
		}
		return ar;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int query[] = getArr(read.readLine());
		int nums[] = getArr(read.readLine());

		int ans[] = nextGreaterElement(nums, query);

		//int n = ans.length;

		// System.out.println(n);
		for (int e : ans) {
			System.out.println(e);
		}

	}
}
