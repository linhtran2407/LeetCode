public class PathSum {

    /*
    @author: Linh Tran
    @version: July 01, 2021

    Runtime and usage info of the solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
    Memory Usage: 38.7 MB, less than 74.26% of Java online submissions for Path Sum.
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null){
                return false;
            }

            targetSum -= root.val;
            // base case
            if (root.left == null && root.right == null){
                return targetSum == 0;
            }

            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        }
    }
}
