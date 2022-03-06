package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class DiameterOfGenericTree {
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

	public static int height(Node node) {
		
		int h = -1;
		
		for (Node child: node.children) {
			int rec_h = height(child);
			h = Math.max(h, rec_h);
		}
		
		return h+1;
	}
	
	// Top Down Approach
	public static int diameter(Node node) {
		// take maximum and 2nd maximum height
		int height = -1;
		int max = -1;
		int smax = -1;

		for (Node child : node.children) {
			height = height(child);
			
			if (height > max) {
				smax = max;
				max = height;
			} else if (height > smax) {
				smax = height;
			}
		}
		
		int dia = max + smax + 2;

		for (Node child: node.children) {
			int cdia = diameter(child);
			dia = Math.max(cdia, dia);
		}
		
		return dia;
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
		int dia = diameter(root);
		System.out.println(dia);
	}

}