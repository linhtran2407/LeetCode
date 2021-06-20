public class MinimumDepthOfABinaryTree {
    /*
    @author: Linh Tran
    @version: Jun 20th, 2021

    Runtime and usage info of the DFS (first) solution:
    Runtime: 4 ms, faster than 75.07% of Java online submissions for Minimum Depth of Binary Tree.
    Memory Usage: 59.8 MB, less than 58.99% of Java online submissions for Minimum Depth of Binary Tree.
    */

     // Definition for a binary tree node.
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {return 0;}
        if (root.left == null) {return minDepth(root.right)+1;}
        if (root.right == null) {return minDepth(root.left)+1;}
        return Math.min(minDepth(root.right)+1, minDepth(root.left)+1);
    }
}
