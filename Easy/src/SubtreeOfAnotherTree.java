public class SubtreeOfAnotherTree {
    /*
    @author: Linh Tran
    @version: July 05, 2021

    Runtime and usage info of the solution:
    Runtime: 3 ms, faster than 94.89% of Java online submissions for Subtree of Another Tree.
    Memory Usage: 39 MB, less than 67.11% of Java online submissions for Subtree of Another Tree.
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
         // TC: O(M*N) with M and N being the number of nodes in tree and subtree
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            // base case
            if (subRoot == null){return true;} // null is the subtree of any tree
            if (root == null){return false;}

            // if the subtree is the tree itself
            if (isIdentical(root, subRoot)){
                return true;
            }

            // otherwise, find subtree in either left or right subtree of the tree
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isIdentical(TreeNode root, TreeNode subRoot){
            if (root == null && subRoot == null){return true;}
            if (root == null || subRoot == null){return false;}

            return root.val == subRoot.val &&
                    isIdentical(root.left, subRoot.left) &&
                    isIdentical(root.right, subRoot.right);
        }
    }
}
