import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    /*
        @author: Linh Tran
        @version: July 22, 2021

        Runtime and usage info of the solution:
        Runtime: 1 ms, faster than 99.98% of Java online submissions for Path Sum II.
        Memory Usage: 39.1 MB, less than 92.68% of Java online submissions for Path Sum II.
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
        List<List<Integer>> result;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<List<Integer>>();
            ArrayList<Integer> pathNodes = new ArrayList<>();
            dfs(root, targetSum, pathNodes);
            return result;
        }

        private void dfs(TreeNode node, int remainingSum, ArrayList<Integer> pathNodes){
            if (node == null){return;}
            pathNodes.add(node.val);

            if (node.left == null && node.right == null && remainingSum == node.val){
                result.add(new ArrayList<>(pathNodes));
            } else {
                dfs(node.left, remainingSum - node.val, pathNodes);
                dfs(node.right, remainingSum - node.val, pathNodes);
            }

            pathNodes.remove(pathNodes.size()-1);
        }
    }
}
