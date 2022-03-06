package dsalevel1.basicds.generictree;

import java.io.*;
import java.util.*;

public class IterativePreorderAndPostorderOfGenericTree {

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

	/*
	public static void preOrderIterative(Node root) {
		
		Stack<Node> st = new Stack<>();
		st.push(root);
		
		while (st.size() > 0) {
			
			Node temp = st.pop();
			System.out.print(temp.data + " ");
			
			for (int i = temp.children.size()-1; i >=0 ; i--) {
				Node child = temp.children.get(i);
				st.push(child);
			}
		}
	}
	*/
	
	public static class Pair {
		Node node;
		int state;
		
		public Pair (Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}
	
	public static void preAndPostOrderIterative(Node root) {
		
		String pre = "";
		String post = "";
		
		//Insert root node with status -1
		//state -1 - means parent node
		//state above 0 means its children
		Stack<Pair> st = new Stack<>();
		Pair p = new Pair(root, -1);
		st.push(p);
		
		while (st.size() > 0) {
			
			Pair t = st.peek();
			
			//state is -1 means parent, so Increase state and Put in preOrder
			if (t.state == -1) {
				t.state++;
				pre += t.node.data + " ";
			} else if (t.state >= 0 && t.state < t.node.children.size()) {
				//state above -1 means take that child
				//Increase State and Put Child in stack
				Pair np = new Pair(t.node.children.get(t.state),-1);
				t.state++;
				st.push(np);
			} else {
				//If all child are complete, then put in post and pop from stack
				post += t.node.data + " ";
				st.pop();
			}
		}
		
		System.out.println(pre);
		System.out.println(post);
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
		//preOrderIterative(root);	
		preAndPostOrderIterative(root);
	}
}
