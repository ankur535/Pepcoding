package dsalevel2.basicds.advancetrees;

import java.util.Scanner;
import java.util.*;

public class BinarySearchTreeIterator2UsingStack {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * This is a better approach as we take space
	 */
	public static class BSTIterator {
		
		Stack<TreeNode> st;
		
		//add all element from node till its leftmost node
		public void addAllLeft (TreeNode node) {
			while (node != null) {
				st.push(node);
				node = node.left;
			}			
		}
		
		public BSTIterator(TreeNode root) {
			st = new Stack<>();
			//add all left node in beginning
			//leftmost stores the min value
			addAllLeft(root);
		}

		public int next() {
			//returning next element
			TreeNode top = st.pop();
			//once pop, add add leftmost of right node of it
			//as next larger will be in leftmost of right node or its parent
			if (top.right != null) {
				addAllLeft(top.right);
			}
			return top.val;
		}

		public boolean hasNext() {
			//until stack is empty, hasNext gives true
			return st.size()>0;
		}
	}

	// input_section=================================================

	public static void display(TreeNode node) {
		if (node == null)
			return;

		StringBuilder sb = new StringBuilder();
		sb.append((node.left != null ? node.left.val : "."));
		sb.append(" -> " + node.val + " <- ");
		sb.append((node.right != null ? node.right.val : "."));

		System.out.println(sb.toString());

		display(node.left);
		display(node.right);

	}

	public static TreeNode constructFromInOrder_(int[] in, int si, int ei) {
		if (si > ei)
			return null;

		int mid = (si + ei) / 2;
		TreeNode node = new TreeNode(in[mid]);

		node.left = constructFromInOrder_(in, si, mid - 1);
		node.right = constructFromInOrder_(in, mid + 1, ei);

		return node;
	}

	public static void solve() {
		int n = scn.nextInt();
		int[] in = new int[n];
		for (int i = 0; i < n; i++)
			in[i] = scn.nextInt();

		TreeNode root = constructFromInOrder_(in, 0, in.length - 1);
		BSTIterator itr = new BSTIterator(root);
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public static void main(String[] args) {
		solve();
	}
}