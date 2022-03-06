package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class NodeWithMaximumSubtreeSumApproach1 {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static void display(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public static Node construct(int[] arr) {
		Node root = null;

		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node();
				t.data = arr[i];

				if (st.size() > 0) {
					st.peek().children.add(t);
				} else {
					root = t;
				}

				st.push(t);
			}
		}

		return root;
	}

	public static int sum(Node node) {

		int sum = 0;

		for (Node child : node.children) {
			sum += sum(child);
		}

		return sum + node.data;
	}

	/**
	 * This is Approach 1 : Top Down Approach With Array 
	 * Here we are using array to store max Node and max Sum 
	 * This will use a additional sum function. 
	 * This code is self-done
	 */
	public static int[] getNodeWithMaxSubtreeSum(Node root) {

		// denote node and sum
		int ans[] = new int[2];
		ans[0] = root.data;
		ans[1] = 0;

		// calculate root node sum
		for (Node child : root.children) {
			ans[1] += sum(child);
		}
		ans[1] += root.data;

		// take maximum sum from child if any
		for (Node child : root.children) {

			int cans[] = getNodeWithMaxSubtreeSum(child);
			if (ans[1] < cans[1]) {
				ans[0] = cans[0];
				ans[1] = cans[1];
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(values[i]);
		}

		Node root = construct(arr);
		// write your code here
		int ans[] = getNodeWithMaxSubtreeSum(root);
		System.out.println(ans[0] + "@" + ans[1]);
	}

}