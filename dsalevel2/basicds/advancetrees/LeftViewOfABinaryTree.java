package dsalevel2.basicds.advancetrees;

import java.util.*;

public class LeftViewOfABinaryTree {
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

		ArrayList<Integer> ans = leftView(root);
		for (Integer i : ans)
			System.out.println(i);
	}

	public static void main(String[] args) {
		solve();
	}
	
	//Write your code here
	
	public static void fillLeftView(TreeNode node, int level, ArrayList<Integer> al) {
		if (node == null) {
			return;
		}
		//based on list size and current level, we add leftview data only
		//data only adding for new leftview level
		if (level == al.size()) {
			al.add(node.val);
		}

		//calling left first to reach leftmost
		fillLeftView(node.left, level + 1, al);
		fillLeftView(node.right, level + 1, al);
	}

	public static ArrayList<Integer> leftView(TreeNode root) {

		ArrayList<Integer> ans = new ArrayList<>();
		fillLeftView(root, 0, ans);
		return ans;

	}
}