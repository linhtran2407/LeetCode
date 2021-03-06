import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MergeTwoBinaryTrees {

        /*
    @author: Linh Tran
    @version: July 03, 2021

    Runtime and usage info of DFS solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
    Memory Usage: 38.9 MB, less than 91.48% of Java online submissions for Merge Two Binary Trees.

    Runtime and usage info of BFS solution:
    Runtime: 1 ms, faster than 31.18% of Java online submissions for Merge Two Binary Trees.
    Memory Usage: 39 MB, less than 83.85% of Java online submissions for Merge Two Binary Trees.
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

    public TreeNode mergeTrees_BFS(TreeNode root1, TreeNode root2) {
         if (root1 == null){
             return root2;
         }

         // if root1 is not null and root2 is null, we ignore it, because we only return root1
        // if both roots are not null, merge them
        Deque<TreeNode[]> dq = new ArrayDeque<>();
         dq.add(new TreeNode[]{root1, root2});

         while(!dq.isEmpty()){
             TreeNode[] curr = dq.poll();

             // if root2 is null, as mentioned, we ignore it
             if (curr[1] == null){
                 continue;
             }

             // if both are not null, merge the vals
             curr[0].val += curr[1].val;

             if (curr[0].left == null){
                 curr[0].left = curr[1].left;
             } else {
                 dq.add(new TreeNode[]{curr[0].left, curr[1].left});
             }

             if (curr[0].right == null){
                 curr[0].right = curr[1].right;
             } else {
                 dq.add(new TreeNode[]{curr[0].right, curr[1].right});
             }
         }

         return root1;
    }
}
