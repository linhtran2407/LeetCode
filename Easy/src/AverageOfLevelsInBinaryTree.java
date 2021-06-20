import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevelsInBinaryTree {

    /*
    @author: Linh Tran
    @version: Jun 20th, 2021

    Runtime and usage info of the iterative solution:
    Runtime: 2 ms, faster than 82.88% of Java online submissions for Average of Levels in Binary Tree.
    Memory Usage: 40.8 MB, less than 78.58% of Java online submissions for Average of Levels in Binary Tree.
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


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        double sum = 0.0;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.remove();

                sum += currNode.val;

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }

            result.add(sum / size);
            sum = 0;
        }

        return result;
    }
}
