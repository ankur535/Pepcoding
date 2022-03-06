package dsalevel2.basicds.advancetrees;

import java.io.*;
import java.util.*;

public class VerticalLevelInABinaryTree {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	// We use stack with Pair - node and state to contruct binary tree
	public static Node construct(Integer[] arr) {

		Node root = new Node(arr[0], null, null);
		Stack<Pair> st = new Stack<>();
		Pair p = new Pair(root, 1);
		st.push(p);

		int idx = 0;
		while (st.size() > 0) {

			Pair t = st.peek();

			if (t.state == 1) {
				idx++;
				if (arr[idx] != null) {
					Node nn = new Node(arr[idx], null, null);
					t.node.left = nn;
					Pair np = new Pair(nn, 1);
					st.push(np);
				} else {
					t.node.left = null;
				}
				t.state++;
			} else if (t.state == 2) {
				idx++;
				if (arr[idx] != null) {
					Node nn = new Node(arr[idx], null, null);
					t.node.right = nn;
					Pair np = new Pair(nn, 1);
					st.push(np);
				} else {
					t.node.right = null;
				}
				t.state++;
			} else {
				st.pop();
			}
		}
		return root;
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	// find max and min for vertical level with recursion
	public static void rec(Node root, int level, int[] minMax) {

		if (root == null) {
			return;
		}
		// update minMax at each node
		minMax[0] = Math.min(minMax[0], level);
		minMax[1] = Math.max(minMax[1], level);

		// left vertical level
		rec(root.left, level - 1, minMax);
		// right vertical level
		rec(root.right, level + 1, minMax);

	}

	public static void fill_VO(ArrayList<ArrayList<Integer>> ans, Node root, int level, int min) {

		if (root == null) {
			return;
		}
		//finding index as min will become index 0 and max as width-1 in arraylist order
		int index = level - min;
		//add node data to correct index arraylist
		ans.get(index).add(root.data);

		fill_VO(ans, root.left, level - 1, min);
		fill_VO(ans, root.right, level + 1, min);

	}

	public static ArrayList<ArrayList<Integer>> getVerticalOrder(Node root) {
		// 0 - min and 1 - max
		int minMax[] = new int[2];
		// find min and max level
		rec(root, 0, minMax);

		int min = minMax[0];
		int max = minMax[1];
		int width = max - min + 1;

		// 2-D arrayList
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		// filling with empty list of width size
		// as that many group of list we will get
		for (int i = 0; i < width; i++) {
			ans.add(new ArrayList<>());
		}

		fill_VO(ans, root, 0, min);

		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (values[i].equals("n") == false) {
				arr[i] = Integer.parseInt(values[i]);
			} else {
				arr[i] = null;
			}
		}

		Node root = construct(arr);
		// display(root);

		ArrayList<ArrayList<Integer>> ans = getVerticalOrder(root);
		for (ArrayList<Integer> ai : ans) {
			System.out.println(ai);
		}
	}

}