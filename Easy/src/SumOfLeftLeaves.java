import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
    /*
    @author: Linh Tran
    @version: Aug 6th, 2021

    Runtime and usage info of BFS solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
    Memory Usage: 36.9 MB, less than 34.28% of Java online submissions for Sum of Left Leaves.

    Runtime and usage info of DFS solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
    Memory Usage: 36.7 MB, less than 62.67% of Java online submissions for Sum of Left Leaves.
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

    class Solution_BFS {
        public int sumOfLeftLeaves(TreeNode root) {
            int ans = 0;
            if (root == null){
                return ans;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();

                for(int i=0; i<size; i++){
                    TreeNode curr = q.poll();

                    TreeNode leftChild = curr.left;
                    if (leftChild != null){
                        if (leftChild.left == null && leftChild.right == null){
                            ans += leftChild.val;
                        }
                        q.add(leftChild);
                    }

                    if (curr.right != null){
                        q.add(curr.right);
                    }
                }
            }

            return ans;
        }
    }

    class Solution_DFS {
        int ans;

        public int sumOfLeftLeaves(TreeNode root) {
            // detect the leaf
            // detect the left leaf
            ans = 0;
            dfs(root);
            return this.ans;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode leftChild = root.left;
            if (leftChild != null && leftChild.left == null && leftChild.right == null) {
                ans += leftChild.val;
            }

            dfs(root.left);
            dfs(root.right);
        }
    }
}
