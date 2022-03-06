package dsalevel2.basicds.advancetrees;

import java.util.Scanner;

public class ConstructBSTFromPreOrderTraversalUsingBetterApproach {
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

        TreeNode root = new TreeNode(0);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
    
    //write your code here
    
    static int idx;
    //upper and lower bound
    public static TreeNode construct(int[] preorder, int lb, int ub) {
        //base condition if value is not in range, append null
        if (idx>=preorder.length || preorder[idx]<lb || preorder[idx]>ub) {
            return null;
        }   
        
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        
        //calling for left tree with new lb and up
        root.left = construct(preorder, lb, root.val);
        //calling for right tree with new lb and up
        root.right = construct(preorder, root.val, ub);
        
        return root;
    }
   
    
    public static TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);       
    }
}