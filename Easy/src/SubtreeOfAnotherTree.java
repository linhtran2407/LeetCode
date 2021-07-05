public class SubtreeOfAnotherTree {

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
