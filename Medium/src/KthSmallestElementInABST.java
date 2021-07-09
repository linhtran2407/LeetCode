import java.util.ArrayList;

public class KthSmallestElementInABST {

/*
    @author: Linh Tran
    @version: July 08, 2021

    Runtime and usage info of DFS solution:
    Runtime: 2 ms, faster than 14.60% of Java online submissions for Kth Smallest Element in a BST.
    Memory Usage: 43 MB, less than 5.31% of Java online submissions for Kth Smallest Element in a BST.
*/

     //Definition for a binary tree node
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
         // TC: O(N)
        // SC: O(N)
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
