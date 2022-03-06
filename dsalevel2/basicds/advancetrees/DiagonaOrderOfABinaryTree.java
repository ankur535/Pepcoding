package dsalevel2.basicds.advancetrees;

import java.util.*;

public class DiagonaOrderOfABinaryTree {
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

		ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
		int idx = 0;
		for (ArrayList<Integer> i : ans) {
			System.out.print(idx++ + " -> ");
			for (Integer j : i)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		solve();
	}
	
	//write your code here

	public static void rec(TreeNode node, int diagonal, ArrayList<ArrayList<Integer>> ans) {
		
		if (node == null) {
			return;
		}
		//if new diagonal, put empty list to populate
		if (diagonal == ans.size()) {
			ans.add(new ArrayList<>());
		}
		//insert element for a particular diagonal
		ans.get(diagonal).add(node.val);
		
		rec(node.left, diagonal+1, ans);
		rec(node.right, diagonal, ans);
	}
	
	public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
	
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		rec(root, 0, ans);
		return ans;
	}
}