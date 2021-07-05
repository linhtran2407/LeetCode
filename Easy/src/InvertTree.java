public class InvertTree {
    /*
        @author: Linh Tran
        @version: July 05, 2021

        Runtime and usage info of the solution:
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
        Memory Usage: 36.4 MB, less than 67.35% of Java online submissions for Invert Binary Tree.
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

    class Solution { // iterative
        public TreeNode invertTree(TreeNode root) {
            if (root == null){
                return null;
            }

            TreeNode cloneRight = invertTree(root.right);
            TreeNode cloneLeft = invertTree(root.left);

            root.right = cloneLeft;
            root.left = cloneRight;

            return root;
        }
    }
}
