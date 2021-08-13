import java.util.*;

/*
        @author: Linh Tran
        @version: Aug 12, 2021

        Runtime and usage info of first solution:
        Runtime: 260 ms, faster than 5.10% of Java online submissions for Maximum Difference Between Node and Ancestor.
        Memory Usage: 39.7 MB, less than 23.64% of Java online submissions for Maximum Difference Between Node and Ancestor.

        Runtime and usage info of second solution:
        Runtime: 7 ms, faster than 30.95% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
        Memory Usage: 45.4 MB, less than 5.05% of Java online submissions for Lowest Common Ancestor of a Binary Tree.

        Runtime and usage info of third solution:
        Runtime: 8 ms, faster than 27.11% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
        Memory Usage: 41 MB, less than 76.50% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
*/

public class MaximumDifferenceBetweenNodeAndAncestor {

     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     // brute force: bfs
    class Solution1 {
        public int maxAncestorDiff(TreeNode root){
            // travel level-by-level
            // store the pair <child, parent> in an map for backtracking
            // for each child, calculate all the differences among all of its anscestors with itself,
            // backtracking using the arraylist
            // TC: O(N^2)
            // SC: O(N)
            int res = Integer.MIN_VALUE;
            Map<TreeNode, TreeNode> parentMap = new HashMap<>();
            parentMap.put(root, null); // root has no parent
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            // start bfs
            while (!q.isEmpty()){
                int size = q.size();

                // traverse through each level
                for (int i=0; i<size; i++){
                    TreeNode curr = q.poll();
                    TreeNode leftCurr = curr.left;
                    TreeNode rightCurr = curr.right;

                    TreeNode temp = curr;
                    // update differences among the node and its ancestors
                    while (temp != null){
                        if (leftCurr != null){
                            res = Math.max(res, Math.abs(temp.val - leftCurr.val));
                        }

                        if (rightCurr != null){
                            res = Math.max(res, Math.abs(temp.val - rightCurr.val));
                        }

                        temp = parentMap.get(temp);
                    }

                    // update the queue to cont. bfs and update parent map
                    if (leftCurr != null){
                        q.add(leftCurr);
                        parentMap.put(leftCurr, curr);
                    }
                    if (rightCurr != null){
                        q.add(rightCurr);
                        parentMap.put(rightCurr, curr);
                    }


                }
            }

            return res;
        }
    }

    // brute force: dfs using recursion
    class Solution2 {
         int ans;
        public int maxAncestorDiff(TreeNode root){
            // using recursion to traverse the tree in dfs
            // pass in a list of ancestors as param
            // once finish assessing both branches of each node
            // pop it out of the list of ancestors
            // inside the function, always update max diff
            // TC: O(N^2)
            // SC: O(N) since the stack mem can take up to N operations
            // when the tree is completely skewed
            ans = 0;
            ArrayList<TreeNode> ancestors = new ArrayList<>();
            helper(root, ancestors);
            return ans;
        }

        private int helper(TreeNode node, ArrayList<TreeNode> ancestors){
            // base case
            if (node == null) return ans;

            // calc all the differences between the current node and its ancestors
            for (int i=0; i<ancestors.size(); i++){

            }
        }
    }
}
