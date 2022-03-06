package dsalevel2.basicds.advancetrees;

import java.util.Scanner;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
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
		int[] post = new int[n];
		for (int i = 0; i < n; i++)
			post[i] = scn.nextInt();

		int[] pre = new int[n];
		for (int i = 0; i < n; i++)
			pre[i] = scn.nextInt();

		TreeNode root = constructFromPrePost(pre, post);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}

	// write your code here

	public static TreeNode build(int[] pre, int psi, int pei, int post[], int posi, int poei) {

		// if we hit a null node, can use psi and pei also
		if (posi > poei) {
			return null;
		}
		// if single root node only, can use psi and pei also and pre[pei]
		if (posi == poei) {
			return new TreeNode(post[poei]);
		}

		// last element of postrder or 1st element of preorder will be always root
		// for each tree and subtree
		// preorder approach - root left right
		// postorder approach - left right root
		TreeNode root = new TreeNode(post[poei]);

		// taking last 2nd of post as right subtree root
		// instead -> we can also take pre[psi+1] as left subtree root
		int right_sub_root = post[poei - 1];

		int j = psi + 1;
		int count = 0;
		// searching for right subtree root in preorder for count
		// instead -> we can also search for left subtree root in postorder
		// if above instead is followed
		while (pre[j] != right_sub_root) {
			j++;
			count++;
		}

		// calling left part of tree using preorder count
		// can also use postorder count
		root.left = build(pre, psi + 1, psi + count, post, posi, posi + count - 1);
		// calling right part of tree using preorder count
		// can also use postorder count
		root.right = build(pre, psi + count + 1, pei, post, posi + count, poei - 1);

		return root;

	}

	public static TreeNode constructFromPrePost(int[] pre, int[] post) {

		return build(pre, 0, pre.length - 1, post, 0, post.length - 1);

	}
}