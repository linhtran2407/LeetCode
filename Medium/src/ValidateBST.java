import java.util.ArrayList;

public class ValidateBST {

/*
    @author: Linh Tran
    @version: Aug 30, 2021

    Runtime and usage info of the iterative solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
    Memory Usage: 38.7 MB, less than 7.54% of Java online submissions for Reverse Linked List II.

    Runtime and usage info of the recursive solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    Memory Usage: 40.3 MB, less than 16.32% of Java online submissions for Validate Binary Search Tree.
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
        ArrayList<Integer> arr;
        boolean check;
        public boolean isValidBST(TreeNode root) {
            // brute force: inorder traversal and check if can create increasing array
            // TC: O(N)
            // SC: O(N)
            arr = new ArrayList<>();
            check = true;
            inorder(root);
            return check;
        }

        private void inorder (TreeNode root){
            if (root == null){return;}

            inorder(root.left);

            if (!arr.isEmpty() && root.val <= arr.get(arr.size()-1)){
                check = false;
                return;
            }
            arr.add(root.val);

            inorder(root.right);
        }

    }

    class Solution_recursion{
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean dfs(TreeNode root, long low, long high){
            if (root == null){return true;}

            // check valid range
            if (root.val <= low || root.val >= high){
                return false;
            }

            return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
        }
    }
}
