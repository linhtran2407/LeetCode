public class LowestCommonAncestorOfABinarySearchTree {


     // Definition for a binary tree node.
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // BST: left < root < right
        // --> find the point where p <= root <= q || p >= root >= q
        // in other case, either root < p, q --> go right subtree
        // or p, q < root --> go left subtree

        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
