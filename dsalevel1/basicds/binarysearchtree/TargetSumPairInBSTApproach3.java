package dsalevel1.basicds.binarysearchtree;

import java.io.*;
import java.util.*;

public class TargetSumPairInBSTApproach3 {
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

	public static class ITPair {
		Node node;
		int state;

		public ITPair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void targetSumPair(Node node, int tar) {

		if (node == null) {
			return;
		}

		Stack<ITPair> lp = new Stack<>();
		Stack<ITPair> rp = new Stack<>();

		lp.push(new ITPair(node, 0));
		rp.push(new ITPair(node, 0));

		Node left = nodeToLeft(lp);
		Node right = nodeToRight(rp);

		while (left.data < right.data) {
			
			if (left.data + right.data < tar) {
				left = nodeToLeft(lp);
			} else if (left.data + right.data > tar) {
				right = nodeToRight(rp);
			} else {
				System.out.println(left.data + " " + right.data);
				left = nodeToLeft(lp);
				right = nodeToRight(rp);
			}
		}
	}

	public static Node nodeToLeft(Stack<ITPair> lp) {

		while (lp.size() > 0) {
			ITPair top = lp.peek();

			if (top.state == 0) {

				if (top.node.left != null) {
					lp.push(new ITPair(top.node.left, 0));
				}
				top.state++;

			} else if (top.state == 1) {

				if (top.node.right != null) {
					lp.push(new ITPair(top.node.right, 0));
				}
				top.state++;

				return top.node;
			} else {
				lp.pop();
			}
		}
		return null;
	}

	public static Node nodeToRight(Stack<ITPair> rp) {

		while (rp.size() > 0) {
			ITPair top = rp.peek();

			if (top.state == 0) {

				if (top.node.right != null) {
					rp.push(new ITPair(top.node.right, 0));
				}
				top.state++;

			} else if (top.state == 1) {

				if (top.node.left != null) {
					rp.push(new ITPair(top.node.left, 0));
				}
				top.state++;

				return top.node;
			} else {
				rp.pop();
			}
		}
		return null;
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