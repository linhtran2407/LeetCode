public class MinimumDistanceBetweenBSTNodes {

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
            // compare diff between root and its rightmost child in the left-subtree
            // and between root and its leftmost child in the right-subtree
            int res = Integer.MAX_VALUE;

            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            if (leftNode != null) {
                res = Math.min(res, minDiffInBST(leftNode));
            }

            if (rightNode != null) {
                res = Math.min(res, minDiffInBST(rightNode));
            }

            while(leftNode != null){
                res = Math.min(res, root.val-leftNode.val);
                leftNode = leftNode.right;
            }

            while(rightNode != null){
                res = Math.min(res, rightNode.val-root.val);
                rightNode = rightNode.left;
            }

            return res;
        }
    }
}
