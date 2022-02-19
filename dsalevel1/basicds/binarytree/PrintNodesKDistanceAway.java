package dsalevel1.basicds.binarytree;

import java.io.*;
import java.util.*;

public class PrintNodesKDistanceAway {
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

	//return node to root path but nodes instead of integer
	public static ArrayList<Node> nodeToRootPath(Node root, int data) {

		if (root == null) {
			return new ArrayList<>();
		}
		if (root.data == data) {
			ArrayList<Node> ans = new ArrayList<>();
			ans.add(root);
			return ans;
		}

		ArrayList<Node> lans = nodeToRootPath(root.left, data);
		if (lans.size() > 0) {
			lans.add(root);
			return lans;
		}

		ArrayList<Node> rans = nodeToRootPath(root.right, data);
		if (rans.size() > 0) {
			rans.add(root);
			return rans;
		}

		return new ArrayList<>();
	}

	public static void printKLevelDown(Node root, int k, Node blocker) {

		//Change if to check for k and blocker to stop going above and in a direction
		if (root == null || k < 0 || root == blocker) {
			return;
		}

		if (k == 0) {
			System.out.println(root.data);
			return;
		}

		printKLevelDown(root.left, k - 1, blocker);
		printKLevelDown(root.right, k - 1, blocker);
	}

	public static void printKNodesFar(Node root, int data, int k) {
		// write your code here
		//Find all node to root path nodes
		ArrayList<Node> ntr = nodeToRootPath(root, data);

		//for each node to root path node, call print k level down
		for (int i = 0; i < ntr.size(); i++) {
			//blocker blocks a direction for a node, based on previous node
			//as we should go only in 1 direction as other direction
			//we can up with
			Node blocker = null;
			if (i > 0) {
				blocker = ntr.get(i - 1);
			}

			printKLevelDown(ntr.get(i), k - i, blocker);
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
		int k = Integer.parseInt(br.readLine());

		Node root = construct(arr);
		printKNodesFar(root, data, k);
	}

}