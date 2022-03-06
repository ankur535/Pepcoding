package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class LowestCommonAncestorInGenericTree {
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

	public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
		if (node.data == data) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(node.data);
			return path;
		}

		for (Node child : node.children) {
			ArrayList<Integer> ptc = nodeToRootPath(child, data);
			if (ptc.size() > 0) {
				ptc.add(node.data);
				return ptc;
			}
		}

		return new ArrayList<>();
	}

	public static int lowestCommonAncestor(Node node, int d1, int d2) {
		// write your code here
		//nodeToRootPath is fucntion to find all ancestors of a node
		//finding arraylist of ancestors 1 for d1
		ArrayList<Integer> anc1 = nodeToRootPath(node, d1);
		//finding arraylist of ancestors 2 for d2
		ArrayList<Integer> anc2 = nodeToRootPath(node, d2);
		
		int i = anc1.size()-1;
		int j = anc2.size()-1;
		
		while (i>= 0 && j >= 0 && anc1.get(i) == anc2.get(j)) {
			i--;
			j--;
		}
		//increase i as it will point to 1 before the lowest ancestor
		//or increase j and do same
		i++;
		return anc1.get(i);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(values[i]);
		}

		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());

		Node root = construct(arr);
		int lca = lowestCommonAncestor(root, d1, d2);
		System.out.println(lca);
		// display(root);
	}

}