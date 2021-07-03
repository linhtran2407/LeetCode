public class MaximumDepthOfBinaryTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        MergeTwoBinaryTrees.TreeNode left;
        MergeTwoBinaryTrees.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, MergeTwoBinaryTrees.TreeNode left, MergeTwoBinaryTrees.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
