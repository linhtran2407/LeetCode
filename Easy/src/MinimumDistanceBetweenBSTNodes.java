public class MinimumDistanceBetweenBSTNodes {

    /*
    @author: Linh Tran
    @version: July 02, 2021

    Runtime and usage info of the solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance Between BST Nodes.
    Memory Usage: 36.7 MB, less than 46.90% of Java online submissions for Minimum Distance Between BST Nodes.
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
        public int minDiffInBST(TreeNode root) {
            // in BST, the smallest dff at each node is between its rightmost node
            // on the left branch with the root, and between its leftmost node
            // on the right branch with the root
            // TC: O(N)
            // SC: for DFS, when tree is skewed, need to contains up to O(N)

            int minDiff = Integer.MAX_VALUE;
            if (root == null){return minDiff;}

            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;

            // recursively go to the left in right branch and
            // to the right in left branch
            // while updating the min diff
            while (leftChild != null){
                minDiff = Math.min (minDiff, root.val - leftChild.val);
                leftChild = leftChild.right;
            }

            while (rightChild != null){
                minDiff = Math.min(minDiff, rightChild.val - root.val);
                rightChild = rightChild.left;
            }

            // compare min diff in 2 branches
            int smallerBranch = Math.min(minDiffInBST(root.left), minDiffInBST(root.right));

            return Math.min(minDiff, smallerBranch);
        }
    }
}
