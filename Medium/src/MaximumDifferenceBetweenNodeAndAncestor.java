public class MaximumDifferenceBetweenNodeAndAncestor {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
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
}
