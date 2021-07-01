public class SameTree {
    /*
@author: Linh Tran
@version: July 01, 2021

Runtime and usage info of the solution:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
Memory Usage: 36.3 MB, less than 74.07% of Java online submissions for Same Tree.
*/
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // DFS: O(N)
            if (p == null && q == null){
                return true;
            }

            if ((p == null && q !=null) || (q == null && p!= null)){
                return false;
            }

            if (p!=null && q!=null){
                return (p.val == q.val) && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
            }

            return true;
        }
    }
}
