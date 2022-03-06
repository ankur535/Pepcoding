package dsalevel2.basicds.advancetrees;

import java.util.Scanner;
import java.util.*;

public class BinarySearchTreeIterator2 {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	static ArrayList<Integer> ans = new ArrayList<>();
	static int i = -1;

	public static void inOrderTravel(TreeNode root) {
		//simple inorder traversal
		if (root == null) {
			return;
		}

		inOrderTravel(root.left);
		ans.add(root.val);
		inOrderTravel(root.right);
	}

	public static class BSTIterator {
		public BSTIterator(TreeNode root) {
			//making inorder - sorted arrayList
			inOrderTravel(root);
		}

		public int next() {
			//returning next element
			i++;
			return ans.get(i);
		}

		public boolean hasNext() {
			//if i+1 is within arraylist
			return (i + 1 < ans.size());
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