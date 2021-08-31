import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ValidateBST {

/*
    @author: Linh Tran
    @version: Aug 30, 2021

    Runtime and usage info of the first solution:
    Runtime: 2 ms, faster than 9.55% of Java online submissions for Validate Binary Search Tree.
    Memory Usage: 41.1 MB, less than 7.81% of Java online submissions for Validate Binary Search Tree.

    Runtime and usage info of the second solution:
    Runtime: 1 ms, faster than 32.30% of Java online submissions for Validate Binary Search Tree.
    Memory Usage: 41.3 MB, less than 5.68% of Java online submissions for Validate Binary Search Tree.

    Runtime and usage info of the third solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    Memory Usage: 40.3 MB, less than 16.32% of Java online submissions for Validate Binary Search Tree.

    Runtime and usage info of the fourth solution:
    Runtime: 4 ms, faster than 6.66% of Java online submissions for Validate Binary Search Tree.
    Memory Usage: 41.9 MB, less than 5.68% of Java online submissions for Validate Binary Search Tree.
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

    class Solution_InOrderArray {
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

    class Solution_recursionWithBounds{
        // TC: O(N) to traverse through every node
        // SC: O(N) for the space required by recursion stack (in case tree is skewed completely)
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

    class Solution_IterativeWithBounds {
        public boolean isValidBST(TreeNode root) {
            // TC: O(N)
            // SC: O(N)
            Queue<Integer> upper = new LinkedList<>();
            Queue<Integer> lower = new LinkedList<>();
            upper.offer(null);
            lower.offer(null);
            Queue<TreeNode> q = new LinkedList<>(); // for iteration
            q.offer(root);
            Integer low, high; // lower and upper bounds
            TreeNode cur = null;

            while (!q.isEmpty()){
                cur = q.poll();
                low = lower.poll();
                high = upper.poll();

                if (cur == null){continue;}
                if ((low != null && cur.val <= low) || (high != null && cur.val >= high)){
                    return false;
                }

                // update queues and lower/upper bounds
                if (cur.left != null){
                    q.add(cur.left);
                    lower.offer(low);
                    upper.offer(cur.val);
                }

                if (cur.right != null){
                    q.add(cur.right);
                    lower.offer(cur.val);
                    upper.offer(high);
                }

            }
            return true;
        }

    }
}
