import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementInABST {

/*
    @author: Linh Tran
    @version: July 08, 2021

    Runtime and usage info of DFS solution:
    Runtime: 2 ms, faster than 14.60% of Java online submissions for Kth Smallest Element in a BST.
    Memory Usage: 43 MB, less than 5.31% of Java online submissions for Kth Smallest Element in a BST.

    Runtime and usage info of BFS solution:
    Runtime: 1 ms, faster than 39.83% of Java online submissions for Kth Smallest Element in a BST.
    Memory Usage: 42.2 MB, less than 13.13% of Java online submissions for Kth Smallest Element in a BST.
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

    class Solution_DFS {
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

    class Solution_BFS {
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();

            while (true){
                while(root != null){
                    stack.add(root);
                    root = root.left;
                }
                root = stack.pop();
                if (--k == 0){return root.val;}
                root = root.right;
            }
        }

    }
}
