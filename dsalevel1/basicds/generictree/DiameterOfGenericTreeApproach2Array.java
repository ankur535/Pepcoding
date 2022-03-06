package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class DiameterOfGenericTreeApproach2Array {
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
		// write your code here
		int h = -1;

		for (Node child : node.children) {
			int rec_height = height(child);
			h = Math.max(rec_height, h);
		}

		return h + 1;
	}

	//same as approach 2, only changes is global variable
	public static int[] diameter3(Node root) {
		int mh = -1;
		int smh = -1;
		int dia = -1;

		for (Node child : root.children) {
			int[] height_dia = diameter3(child);
			int height = height_dia[0];
			dia = Math.max(dia, height_dia[1]);
			if (height > mh) {
				smh = mh;
				mh = height;
			} else if (height > smh) {
				smh = height;
			}
		}
		dia = Math.max(dia, mh + smh + 2);

		int[] ans = new int[2];
		ans[0] = mh + 1;
		ans[1] = dia;

		return ans;
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
		int ans[] = diameter3(root);
		System.out.println(ans[1]);
	}

}