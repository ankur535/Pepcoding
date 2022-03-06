package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class NodeWithMaximumSubtreeSumApproach2Array {
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

	/**
	 	This is Approach 2 : Bottom Up Approach With Array
	 	Here we are using array to store max Node and max Sum
	 	This is a sum function only with a little change
	 */
	public static int getNodeWithMaxSubtreeSum (Node root, int[] ans) {
		
		int sum = 0;
		
		for (Node child: root.children) {
			//getting sum of child, same as sum function
			sum += getNodeWithMaxSubtreeSum(child, ans);
		}
		
		sum += root.data;
		//checking while calculating sum itself for max value
		if (sum > ans[1]) {
			ans[0] = root.data;
			ans[1] = sum;
		}
		return sum;
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
		int ans[] = new int[2];
		ans[0] = 0;
		ans[1] = Integer.MIN_VALUE;
		getNodeWithMaxSubtreeSum(root, ans);
		
		System.out.println(ans[0]+"@"+ans[1]);
	}

}