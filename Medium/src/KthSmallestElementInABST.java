import java.util.ArrayList;

public class KthSmallestElementInABST {


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

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            ArrayList<Integer> res = traversal(root, new ArrayList<Integer>());
            return (res.get(k-1));
        }

        private ArrayList<Integer> traversal(TreeNode root, ArrayList<Integer> list){
            if (root == null){return list;}
            traversal(root.left, list);
            list.add(root.val);
            traversal(root.right, list);

            return list;
        }
    }
}
