package dsalevel1.basicds.binarysearchtree;

import java.io.*;
import java.util.*;

public class SizeSumMaxMinFindInBinarySearchTree {
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

	//Do in O(n)
	public static int size(Node node) {
		// write your code here
		if (node == null) {
			return 0;
		}
		
		int size = 0;
		
		size += size(node.left);
		size += size(node.right);
		
		return size+1;
	}
	
	//Do in O(n)
	public static int sum(Node node) {
		// write your code here
		if (node == null) {
			return 0;
		}
		
		int sum = 0;
		
		sum += sum(node.left);
		sum += sum(node.right);
		
		return sum+node.data;
	}
	
	//Do in O(logn)
	public static int max(Node node) {
		// write your code here
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		
		if (node.right == null) {
			return node.data;
		}
		
		return max(node.right);
	}
	
	//Iterative approach
	public static int max2(Node node) {
		// write your code here
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		
		while (node.right != null) {
			node = node.right;
		}
		return node.data;		
	}
	
	//Do in O(logn)
	public static int min(Node node) {
		// write your code here
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		
		if (node.left == null) {
			return node.data;
		}
		
		return min(node.left);
	}
	
	//Iterative approach
	public static int min2(Node node) {
		// write your code here
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		
		while (node.right != null) {
			node = node.right;
		}
		return node.data;	
	}
	
	//Do in O(logn)
	public static boolean find(Node node, int data) {
		// write your code here
		if (node == null) {
			return false;
		}
		
		if (node.data > data) {
			return find(node.left, data);
		} else if (node.data < data) {
			return find(node.right, data);
		} else {
			return true;
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

		int size = size(root);
		int sum = sum(root);
		int max = max(root);
		int min = min(root);
		boolean found = find(root, data);

		System.out.println(size);
		System.out.println(sum);
		System.out.println(max);
		System.out.println(min);
		System.out.println(found);
	}

}