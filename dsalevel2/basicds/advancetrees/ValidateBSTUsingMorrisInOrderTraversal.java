package dsalevel2.basicds.advancetrees;

import java.util.Scanner;

public class ValidateBSTUsingMorrisInOrderTraversal {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode createTree(int[] arr, int[] IDX) {
		if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
			IDX[0]++;
			return null;
		}

		TreeNode node = new TreeNode(arr[IDX[0]++]);
		node.left = createTree(arr, IDX);
		node.right = createTree(arr, IDX);

		return node;
	}

	public static void solve() {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int[] IDX = new int[1];
		TreeNode root = createTree(arr, IDX);
		System.out.println(isValidBST(root));
	}

	public static void main(String[] args) {
		solve();
	}
	
	//write your code here
	public static TreeNode rightMost(TreeNode left, TreeNode curr) {

		//going to rightmost node of left pointed node
		TreeNode node = left;
		while (node.right != null && node.right != curr) {
			node = node.right;
		}

		return node;
	}

	public static boolean morrisInTraversal(TreeNode root) {

		//taking curr node
		TreeNode curr = root;
		TreeNode prev = null;

		//until we finish with the last node
		while (curr != null) {

			//taking left
			TreeNode left = curr.left;

			//if left is null, curr will move back using thread
			if (left == null) { 
				//chekcing in inorder flow
				if (prev != null) {
					if (prev.val >= curr.val) {
						return false;
					}
				}
				prev = curr;
				//here we might be going right for right subtree or via thread 
				curr = curr.right;
			} else {
				//finding righmost of that left node
				TreeNode rm = rightMost(left, curr);

				if (rm.right == null) { //thread creation
					rm.right = curr;
					curr = left;
				} else {				//thread breaking
					rm.right = null;
					//chekcing in inorder flow
					if (prev != null) {
						if (prev.val >= curr.val) {
							return false;
						}
					}
					prev = curr;
					curr = curr.right;					
				}
			}
		}

		return true;
	}
	
	public static boolean isValidBST(TreeNode root) {
		
		return morrisInTraversal(root);
	}
}