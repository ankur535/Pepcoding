package dsalevel2.basicds.advancetrees;

import java.util.Scanner;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
    
    //write your code here
    
public static TreeNode build(int[] ino, int isi, int iei, int[] post, int posi, int poei) {
    	
    	//if reached a null node
    	if (posi > poei) {
    		return null;
    	}
    	//if single root node only
    	if (posi == poei) {
    		return new TreeNode(post[poei]);
    	}
    	
    	//last element of postorder will be always root for each tree and subtree
    	//postorder approach -  left  right  root
    	TreeNode root = new TreeNode(post[poei]);
    	
    	int j = isi;
    	int count = 0;
    	
    	//finding value in inorder to get left and right tree from inorder
    	//inorder approach - left  root  right
    	while(ino[j] != root.val) {
    		j++;
    		count++;
    	}
    	
    	//calling left part of tree using inorder count, as left of inorder 
    	//root will be left subtree
    	root.left = build(ino, isi, isi+count-1, post, posi, posi+count-1);
    	//calling right part of tree using inorder count, as right of inorder 
    	//root will be right subtree
    	root.right = build(ino, isi+count+1, iei, post, posi+count, poei-1);
    	
    	/* Or this can be done
    	 	finding using postorder ending index instead of start index
    	 	
    	root.left = build(ino, isi, isi+count-1, post, posi, poei-count-1);
    	root.right = build(ino, isi+count+1, iei, post, poei-count, poei-1);
    	*/
    	return root;
    	
    } 
    
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
       
    	return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
	
}