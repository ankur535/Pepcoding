package dsalevel2.basicds.advancetrees;

import java.util.Scanner;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
		int[] pre = new int[n];
		for (int i = 0; i < n; i++)
			pre[i] = scn.nextInt();

		int[] in = new int[n];
		for (int i = 0; i < n; i++)
			in[i] = scn.nextInt();

		TreeNode root = buildTree(pre, in);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}

	
	//write your code down
	/*
	 psi - preorder start index
	 pei - preorder end index
	 
	 isi - inorder start index
	 iei - inorder end index
	 
	 */
	public static TreeNode build(int[] pre, int psi, int pei, int[] ino, int isi, int iei) {
		
		//if reached a null node
		if (psi > pei) {
			return null;
		}
		//if single root node only
		if (psi == pei) {
			return new TreeNode(pre[psi]);
		}
		
		//1st element of preorder will be always root for each tree and subtree
		//preorder approach -  root  left  right
		TreeNode root = new TreeNode(pre[psi]);
		
		int j = isi;
		int count = 0;
		
		//finding value in inorder to get left and right tree from inorder
		//inorder approach - left  root  right
		while (ino[j] != root.val) {
			j++;
			count++;
		}
		
		//calling left part of tree using inorder count, as left of inorder 
		//root will be left subtree
		root.left = build(pre, psi+1, psi+count, ino, isi, isi+count-1);
		//calling right part of tree using inorder count, as right of inorder 
		//root will be right subtree
		root.right = build(pre, psi+count+1, pei, ino, isi+count+1, iei);		
		
		return root;
	}	
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		
		return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
}