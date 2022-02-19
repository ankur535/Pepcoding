package dsalevel1.basicds.binarytree;

import java.io.*;
import java.util.*;

public class ConstructAndDisplayABinaryTree {
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

	//We use stack with Pair - node and state to contruct binary tree
	public static Node construct(Integer[] arr) {

	    Node root = new Node(arr[0], null, null);
	    Stack<Pair> st = new Stack<>();
	    Pair p = new Pair(root, 1);
	    st.push(p);

	    int idx = 0;
	    while (st.size() > 0) {
	      
	      Pair t = st.peek();

	      if (t.state == 1) {
	        idx++;
	        if (arr[idx] != null) {
	          Node nn = new Node(arr[idx], null, null);
	          t.node.left = nn;
	          Pair np = new Pair(nn, 1);
	          st.push(np);
	        } else {
	          t.node.left = null;
	        }
	        t.state++;
	      } else if (t.state == 2) {
	        idx++;
	        if (arr[idx] != null) {
	          Node nn = new Node(arr[idx], null, null);
	          t.node.right = nn;
	          Pair np = new Pair(nn, 1);
	          st.push(np);
	        } else {
	          t.node.right = null;
	        }
	        t.state++;
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
		display(root);
	}

}