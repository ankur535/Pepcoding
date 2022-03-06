package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class MultiSolverForGenericTree {
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

	static int size;
	static int sum;
	static int min;
	static int max;
	
	public static void multiSolver(Node node) {
		
		size += 1;
		sum += node.data;
		min = Math.min(min, node.data);
		max = Math.max(max, node.data);
		
		for (Node child: node.children) {
			multiSolver(child);
		}
	}
	
	public static void multiSolver2(Node node, int[] ans) {
		
		ans[0] += 1;
		ans[1] += node.data;
		ans[2] = Math.min(ans[2], node.data);
		ans[3] = Math.max(ans[3], node.data);
		
		for (Node child: node.children) {
			multiSolver2(child, ans);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n1 = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n1];
		String[] values1 = br.readLine().split(" ");
		for (int i = 0; i < n1; i++) {
			arr1[i] = Integer.parseInt(values1[i]);
		}
		Node root1 = construct(arr1);
		
		size = 0;
		sum = 0;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		multiSolver(root1);
		
		//if don't want to use global variable use heap
		int ans[] = new int[4];
		ans[0] = 0; //size
		ans[1] = 0; //sum
		ans[2] = Integer.MAX_VALUE; //min
		ans[3] = Integer.MIN_VALUE; //max
		multiSolver2(root1, ans);
		
		System.out.println("Global Variable");
		System.out.println(size);
		System.out.println(sum);
		System.out.println(min);
		System.out.println(max);
		
		System.out.println("Heap memory");
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
		System.out.println(ans[3]);
	}

}