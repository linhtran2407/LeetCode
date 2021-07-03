import java.util.ArrayDeque;
import java.util.Deque;

public class MergeTwoBinaryTrees {


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

    public TreeNode mergeTrees_DFS(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        }

        if (root1 != null && root2 == null){
            return root1;
        }

        if (root1 == null && root2 != null){
            return root2;
        }

        // merge the values if both roots are not null
        root1.val += root2.val;
        // merge for both left and right subtree
        root1.left = mergeTrees_DFS(root1.left, root2.left);
        root1.right = mergeTrees_DFS(root1.right, root2.right);

        return root1;
    }

}
