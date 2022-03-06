package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class IsGenericTreeSymmetric {
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

	public static int size(Node node) {
		int s = 0;

		for (Node child : node.children) {
			s += size(child);
		}
		s += 1;

		return s;
	}

	public static int max(Node node) {
		int m = Integer.MIN_VALUE;

		for (Node child : node.children) {
			int cm = max(child);
			m = Math.max(m, cm);
		}
		m = Math.max(m, node.data);

		return m;
	}

	public static int height(Node node) {
		int h = -1;

		for (Node child : node.children) {
			int ch = height(child);
			h = Math.max(h, ch);
		}
		h += 1;

		return h;
	}

	public static boolean areMirror(Node n1, Node n2) {
		// write your code here
		// if n1 and n2 have different size, then false
		if (n1.children.size() != n2.children.size()) {
			return false;
		}

		int i = 0;
		int j = n1.children.size() - 1;

		while (i < n1.children.size()) {
			// taking 1st of n1 node and last of n2 node and traversing opposite
			Node child1 = n1.children.get(i);
			Node child2 = n2.children.get(j);
			boolean ans = areMirror(child1, child2);

			if (ans == false) {
				return ans;
			}
			i++;
			j--;
		}
		return true;
	}

	public static boolean IsSymmetric(Node node) {
		// write your code here
		// symmetric is tree is mirror of itself
		// If mirror image of an object is the object itself, then that object is symmetric
		return areMirror(node, node);
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
		boolean sym = IsSymmetric(root);
		System.out.println(sym);
		// display(root);
	}

}