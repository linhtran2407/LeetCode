public class DiameterOfBinaryTree {
/*
    @author: Linh Tran
    @version: July 04, 2021

    Runtime and usage info of the solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
    Memory Usage: 38.9 MB, less than 63.39% of Java online submissions for Diameter of Binary Tree.
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

    class Solution {
        int diameter;
        public int diameterOfBinaryTree(TreeNode root) {
            diameter = 0;
            longestPath(root);
            return diameter;
        }

        private int longestPath(TreeNode root){
            if (root == null){
                return 0;
            }

            if (root.left == null && root.right == null){
                return 1;
            }

            // find the longest path on each subtree
            int leftPath = longestPath(root.left);
            int rightPath = longestPath(root.right);

            // update the diameter if there is any path not
            // passing root but is the longest diameter
            diameter = Math.max(diameter, leftPath+rightPath);

            // return the longer path out of two paths and
            // plus 1 for the edge connecting with the root
            return Math.max(leftPath, rightPath)+1;
        }
    }
}
