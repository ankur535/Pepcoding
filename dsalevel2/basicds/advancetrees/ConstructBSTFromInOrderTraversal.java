package dsalevel2.basicds.advancetrees;

import java.util.Scanner;

public class ConstructBSTFromInOrderTraversal {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
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

	public static void solve() {
		int n = scn.nextInt();
		int[] in = new int[n];
		for (int i = 0; i < n; i++)
			in[i] = scn.nextInt();

		TreeNode root = constructFromInOrder(in);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}
	
	//write your code here
	
	public static TreeNode construct(int[] inOrder, int si, int ei) {

		if (si > ei) {
			return null;
		}

		// taking mid as root
		int mid = (si + ei) / 2;

		TreeNode node = new TreeNode(inOrder[mid]);

		// calling for left and right subtree
		node.left = construct(inOrder, si, mid - 1);
		node.right = construct(inOrder, mid + 1, ei);

		return node;

	}

	public static TreeNode constructFromInOrder(int[] inOrder) {
		return construct(inOrder, 0, inOrder.length - 1);
	}
}