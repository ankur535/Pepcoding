package dsalevel2.basicds.advancetrees;

import java.util.*;

public class PreOrderMorrisTraversalInBinaryTree {
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

	public static TreeNode createTree(int[] arr, int[] IDX) {
		if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
			IDX[0]++;
			return null;
		}
		TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
		Treenode.left = createTree(arr, IDX);
		Treenode.right = createTree(arr, IDX);

		return Treenode;
	}

	public static void solve() {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int[] IDX = new int[1];
		TreeNode root = createTree(arr, IDX);

		ArrayList<Integer> ans = morrisPreTraversal(root);
		for (Integer i : ans)
			System.out.print(i + " ");

	}

	public static void main(String[] args) {
		solve();
	}

	// write your code here

	public static TreeNode rightMost(TreeNode left, TreeNode curr) {

		// going to rightmost node of left pointed node
		TreeNode node = left;
		while (node.right != null && node.right != curr) {
			node = node.right;
		}

		return node;
	}

	public static ArrayList<Integer> morrisPreTraversal(TreeNode root) {

		// taking curr node
		TreeNode curr = root;
		ArrayList<Integer> ans = new ArrayList<>();

		// until we finish with the last node
		while (curr != null) {

			// taking left
			TreeNode left = curr.left;

			// if left is null, curr will move back using thread
			if (left == null) {
				// as left is null so adding curr in preorder
				ans.add(curr.val);
				// here we might be going right for right subtree or via thread
				curr = curr.right;
			} else {
				// finding righmost of that left node
				TreeNode rm = rightMost(left, curr);

				if (rm.right == null) { // thread creation
					rm.right = curr;
					// going left so adding in preorder
					ans.add(curr.val);
					curr = left;
				} else { // thread breaking
					rm.right = null;
					curr = curr.right;
				}
			}
		}

		return ans;
	}
}
