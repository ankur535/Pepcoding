package dsalevel2.basicds.advancetrees;

import java.util.Scanner;

public class ValidateBST {
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
	//taking 2 global variable
	static TreeNode prev;
	static boolean res;
	
	public static void travel(TreeNode root) {
		
		if (root == null) {
			return;
		}
		//this will reduce that extra node traversal as mentioned in line 66 comment
		if (res == false) {
			return;
		}
		
		travel(root.left);
		
		//checking for prev and curr root in inorder
		if (prev != null) {
			if (prev.val >= root.val) {
				//once it is false, it will go to remaining nodes of tree but 
				//will res false as once false it is not again updating to true
				res = false;
				return;
			}
		}
		prev = root;
		
		travel(root.right);
	}
	
	public static boolean isValidBST(TreeNode root) {
		
		prev = null;
		res = true;
		//travelling in the tree and making use of inorder
		travel(root);		
		return res;
	}
}