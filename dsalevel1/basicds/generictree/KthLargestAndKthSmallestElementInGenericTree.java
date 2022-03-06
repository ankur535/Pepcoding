package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class KthLargestAndKthSmallestElementInGenericTree {
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

	static int ceil;
	static int floor;

	public static void ceilAndFloor(Node node, int data) {
		if (node.data > data) {
			if (node.data < ceil) {
				ceil = node.data;
			}
		}

		if (node.data < data) {
			if (node.data > floor) {
				floor = node.data;
			}
		}

		for (Node child : node.children) {
			ceilAndFloor(child, data);
		}
	}

	public static int kthLargest(Node node, int k) {
		// write your code here
		int largest = Integer.MAX_VALUE;
		
		for (int i = 0; i < k; i++) {
			ceilAndFloor(node, largest);
			largest = floor;
			floor = Integer.MIN_VALUE;
		}
		return largest;
	}
	
	public static int kthSmallest(Node node, int k) {
		// write your code here
		int smallest = Integer.MIN_VALUE;
		
		for (int i = 0; i < k; i++) {
			ceilAndFloor(node, smallest);
			smallest = ceil;
			ceil = Integer.MAX_VALUE;
		}
		return smallest;
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(values[i]);
		}

		int k = Integer.parseInt(br.readLine());
		
		Node root = construct(arr);
		ceil = Integer.MAX_VALUE;
		floor = Integer.MIN_VALUE;
		int kthLargest = kthLargest(root, k);
		System.out.println(kthLargest);
		
		int kthSmallest = kthSmallest(root, k);
	    System.out.println(kthSmallest);
	}

}