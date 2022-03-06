package dsalevel2.basicds.advancetrees;

import java.util.*;

public class TopViewOfABinaryTree {
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

		ArrayList<Integer> ans = TopView(root);
		for (Integer i : ans)
			System.out.print(i + " ");

	}

	public static void main(String[] args) {
		solve();
	}

	// Write your code here

	public static class Pair {
		TreeNode node;
		int level;
		
		public Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	
	public static void travel(TreeNode root, int level, int[] minMax) {

		if (root == null) {
			return;
		}

		minMax[0] = Math.min(level, minMax[0]);
		minMax[1] = Math.max(level, minMax[1]);

		travel(root.left, level - 1, minMax);
		travel(root.right, level + 1, minMax);
	}

	public static ArrayList<Integer> TopView(TreeNode root) {
		
		//finding width of tree
		int minMax[] = new int[2];
		travel(root, 0, minMax);
		
		int width = minMax[1] - minMax[0] + 1;
		int min = minMax[0];
		
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i=0; i<width; i++) {
			ans.add(-1);
		}
		
		//level-order traversal
		LinkedList<Pair> que = new LinkedList<>();
		que.addLast(new Pair(root, 0));
		
		while (que.size() > 0) {
			
			Pair t = que.removeFirst();
			
			TreeNode n = t.node;
			int level = t.level;
			
			//finding index for arraylist
			int index = level-min;
			
			if (ans.get(index) == -1) {
				ans.set(index, n.val);
			}
			
			if (n.left != null) {
				que.addLast(new Pair(n.left, level-1));
			}
			
			if (n.right != null) {
				que.addLast(new Pair(n.right, level+1));
			}
		}
		
		return ans;
	}

}