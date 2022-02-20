package dsalevel1.basicds.binarysearchtree;

import java.io.*;
import java.util.*;

public class TargetSumPairInBSTApproach2 {
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

	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rtp = new Pair(root, 1);

		Stack<Pair> st = new Stack<>();
		st.push(rtp);

		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					top.node.left = new Node(arr[idx], null, null);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}

				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					top.node.right = new Node(arr[idx], null, null);
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				} else {
					top.node.right = null;
				}

				top.state++;
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

	public static void inOrderArray(Node node, ArrayList<Integer> ans) {
		//this function populates arraylist in inorder manner
		if (node  == null) {
			return;
		}
		
		inOrderArray(node.left, ans);
		ans.add(node.data);		
		inOrderArray(node.right, ans);
	}
	
	public static void targetSumPair(Node root, int tar) {

		if (root == null) {
			return;
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		inOrderArray(root, ans);
		
		int i = 0;
		int j = ans.size()-1;
		//we can travel from front and back and if sum is less, increase i
		//if sum is more decrease larger value by decreasing j
		//else if equal print
		while (i < j) {
			int sum = ans.get(i) + ans.get(j);
			if (sum < tar) {
				i++;
			} else if (sum > tar) {
				j--;
			} else {
				System.out.println(ans.get(i) + " " + ans.get(j));
				i++;
				j--;
			}
		}
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

		int data = Integer.parseInt(br.readLine());

		Node root = construct(arr);
		// write your code here
		targetSumPair(root, data);
	}

}