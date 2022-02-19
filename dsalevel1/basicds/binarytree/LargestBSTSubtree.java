package dsalevel1.basicds.binarytree;

import java.io.*;
import java.util.*;

public class LargestBSTSubtree {
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

	//BST Pair now include size and maxNode
	public static class BSTPair {
		boolean isbst;
		int max;
		int min;
		int size;
		Node max_Node;
		
		public BSTPair(boolean isbst, int max, int min, int size, Node max_Node) {
			this.isbst = isbst;
			this.max = max;
			this.min = min;
			this.size = size;
			this.max_Node = max_Node;
		}
	}
	
	public static BSTPair largestBST(Node root) {
		
		if (root == null) {
			BSTPair p = new BSTPair(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, null);
			return p;
		}
		
		BSTPair lp = largestBST(root.left);
		BSTPair rp = largestBST(root.right);
		
		if (lp.isbst == true && rp.isbst == true && lp.max < root.data && root.data < rp.min) {
			int max = Math.max(rp.max, root.data);
			int min = Math.min(lp.min, root.data);
			//calculate size
			int size = lp.size + rp.size + 1;
			//root is now new maximum node
			BSTPair p = new BSTPair(true,max, min, size, root);
			return p;
		} 
		
		//if not a BST
		BSTPair bp = new BSTPair(false, -1, -1, 0, null);
		//Check for lp and rp size as if not BST, send the subtree data which is BST
		//so that when we return from root node, it will have detail of that node
		//which has bst and is largest
		if (lp.size > rp.size) {
			bp.size = lp.size;
			bp.max_Node = lp.max_Node;
		} else {
			bp.size = rp.size;
			bp.max_Node = rp.max_Node;
		}
		
		return bp;		
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
		// write your code here
		
		BSTPair p = largestBST(root);
		System.out.println(p.max_Node + "@" + p.size);
	}

}