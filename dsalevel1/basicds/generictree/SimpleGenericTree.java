package dsalevel1.basicds.generictree;

import java.util.*;

public class SimpleGenericTree {

	public static class Node {	
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	
	//Construct tree
	public static Node construct(int arr[]) {
		
		Node root = new Node();
		root.data = arr[0];
		
		Stack<Node> st =new Stack<>();
		st.push(root);
		
		for (int i = 1; i<arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node node = new Node();
				node.data = arr[i];
				
				Node top = st.peek();
				top.children.add(node);
				st.push(node);
			}
		}
		
		return root;
	}
	
	//Display the tree 
	public static void display(Node root) {
		
		System.out.print(root.data + " -> ");
		//printing all children of current root
		//this loop will not execute for leaf node
		for (int i = 0; i < root.children.size(); i++) {
			Node child = root.children.get(i);
			System.out.print(child.data + " ");
		}
		System.out.println(".");
		
		//now root's children will go and print there data.
		//this loop will not execute for leaf node
		for (int i = 0; i < root.children.size(); i++) {
			display(root.children.get(i));
		}	
	}
	
	public static void main(String[] args) throws Exception {
		
		/*
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(values[i]);
	    }
		 */
		
		int[] arr={10,50,60,-1,-1,20,70,-1,80,120,-1,-1,90,130,-1,-1,-1,30,-1,40,100,-1,110,-1,-1,-1};

	    Node root = construct(arr);
	    display(root); 
	  }
}
