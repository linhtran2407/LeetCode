import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    @author: Linh Tran
    @version: May 31, 2021

    Runtime and usage info of the first solution:
    Runtime: 1 ms, faster than 76.08% of Java online submissions for Binary Tree Right Side View.
    Memory Usage: 37.7 MB, less than 53.14% of Java online submissions for Binary Tree Right Side View.
 */

public class BinaryTreeRightSideView {

     //Definition for a binary tree node.
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {return result;}

        Queue<TreeNode> queue = new LinkedList<>();
        // initiate the queue with root
        queue.add(root);

        while(!queue.isEmpty()){

            int currSize = queue.size();

            // check if it's the rightmost element
            for (int i =0; i<currSize; i++){
                TreeNode currRoot = queue.remove();
                if (i==currSize-1) {
                    result.add(currRoot.val);
                }
                if (currRoot.left != null) {
                    queue.add(currRoot.left);
                }
                if (currRoot.right != null) {
                    queue.add(currRoot.right);
                }
            }
        }

        return result;
    }
}
