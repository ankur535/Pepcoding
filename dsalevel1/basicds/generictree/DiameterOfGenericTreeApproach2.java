package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class DiameterOfGenericTreeApproach2 {
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
	
	static int global_dia;
	
	/**
	 * Here we reduce time complexity to O(n) instead of n^2 as before
	 * 
	 * We are retrieving height but calculating diameter
	 * these type of will be many where we calculate 1 thing
	 * but found another
	 * 
	 * Bottom Up Approach/ Better than approach 1
	 * 
	 * This is a height function with a minimal change of calculating diameter
	 */
	public static int diameter2(Node node) {
		//take maximum and 2nd maximum height
		int mh = -1;
		int smh = -1;
		
		for (Node child: node.children) {
			int h = diameter2(child);
			if (h > mh) {
				smh = mh;
				mh = h;
			} else if (h > smh) {
				smh = h;
			}
		}
		//calculate diameter
		int dia = mh + smh + 2;
		global_dia = Math.max(dia, global_dia);
		
		return mh+1;
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
		diameter2(root);
		System.out.println(global_dia);
	}

}