public class LowestCommonAncestorOfABinaryTree {
/*
        @author: Linh Tran
        @version: July 29, 2021

        Runtime and usage info of the solution:
        Runtime: 7 ms, faster than 30.95% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
        Memory Usage: 45.4 MB, less than 5.05% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    */


     //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        TreeNode ans;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p ,q);
            return this.ans;
        }

        private boolean dfs(TreeNode node, TreeNode p, TreeNode q){
            if (node == null){return false;}
            // if p or q is in either branch, set that branch to 1
            int left = dfs(node.left, p, q)? 1:0;
            int right = dfs(node.right, p, q)? 1:0;
            // in case the ancestor is either p or q itself
            int mid = (node == p || node == q)? 1:0;

            // if find 2 (or more) flags at each recursion
            if (mid+left+right >=2){
                ans = node;
            }

            // any one of the flags is true is enough
            return (mid+left+right)>0;
        }
    }
}
