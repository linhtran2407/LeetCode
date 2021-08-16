public class MinimumDistanceBetweenBSTNodes {

    /*
    @author: Linh Tran
    @version: July 02, 2021

    Runtime and usage info of the first solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance Between BST Nodes.
    Memory Usage: 36.7 MB, less than 46.90% of Java online submissions for Minimum Distance Between BST Nodes.

    Runtime and usage info of the second solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance Between BST Nodes.
    Memory Usage: 36.7 MB, less than 33.21% of Java online submissions for Minimum Distance Between BST Nodes.
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

    class Solution1 {
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

    class Solution2 {
          Integer prev, ans;
        public int minDiffInBST(TreeNode root) {
            // idea: in-order traversal of BST outputs the tree in correct ascending order
            // --> iterate the tree in-order manner, calc the difference between each node's val
            // and its prev value
            prev = null;
            ans = Integer.MAX_VALUE;
            inorder(root);
            return ans;
        }

        private void inorder(TreeNode root){
            if (root == null) return;

            // visit the left branch first
            inorder(root.left);

            // visit root
            if (prev != null)
                ans = Math.min(ans, root.val - prev);
            // set the current node's value to be prev
            // for the next recursion
            prev = root.val;

            // visit the right branch lastly
            inorder(root.right);
        }
    }
}
