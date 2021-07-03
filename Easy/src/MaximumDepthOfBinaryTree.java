public class MaximumDepthOfBinaryTree {

            /*
    @author: Linh Tran
    @version: July 03, 2021

    Runtime and usage info of the solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    Memory Usage: 38.4 MB, less than 99.24% of Java online submissions for Maximum Depth of Binary Tree.
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

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }

        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }

}
