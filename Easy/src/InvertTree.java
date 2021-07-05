import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    /*
        @author: Linh Tran
        @version: July 05, 2021

        Runtime and usage info of DFS solution:
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
        Memory Usage: 36.4 MB, less than 67.35% of Java online submissions for Invert Binary Tree.

        Runtime and usage info of BFS solution:
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
        Memory Usage: 36.4 MB, less than 67.35% of Java online submissions for Invert Binary Tree.
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

    class Solution { // iterative
        // TC: O(N)
        public TreeNode invertTree_DFS(TreeNode root) {
            if (root == null){
                return null;
            }

            TreeNode cloneRight = invertTree_DFS(root.right);
            TreeNode cloneLeft = invertTree_DFS(root.left);

            root.right = cloneLeft;
            root.left = cloneRight;

            return root;
        }


        public TreeNode invertTree_BFS(TreeNode root) {
            if (root == null){
                return null;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                TreeNode curr = q.poll();

                TreeNode cloneLeft = curr.left;
                curr.left = curr.right;
                curr.right = cloneLeft;

                if (curr.left != null){q.add(curr.left);}
                if (curr.right != null){q.add(curr.right);}
            }

            return root;
        }
    }
}
