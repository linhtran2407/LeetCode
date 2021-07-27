public class AllNodesDistanceKInBinaryTree {

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
        Map<TreeNode, TreeNode> parentMap;
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            parentMap = new HashMap<>();
            // dfs to annotate parent
            dfs(root, null);

            // bfs to find k-distance nodes
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(target);
            // ignore visited node, hashset is ideal thanks to O(1) contains method
            Set<TreeNode> seen = new HashSet<>();
            int size = 0;
            int dist = 0;
            while(!q.isEmpty()){
                size = q.size();

                // if found the correct distance
                if (dist == k){
                    for (int i=0; i<size; i++){
                        res.add(q.poll().val);
                    }
                    return res;
                }

                dist++;

                // add all children and parenti if not visited yet
                // to cont. bfs
                for (int i=0; i<size; i++){
                    TreeNode curr = q.poll();
                    seen.add(curr);

                    if (curr.left != null && !seen.contains(curr.left)){
                        q.add(curr.left);
                    }

                    if (curr.right != null && !seen.contains(curr.right)){
                        q.add(curr.right);
                    }

                    TreeNode par = parentMap.get(curr);
                    if (par != null && !seen.contains(par)){
                        q.add(par);
                    }
                }
            }

            return res;
        }

        private void dfs(TreeNode child, TreeNode par){
            if (child!=null){
                parentMap.put(child, par);
                dfs(child.left, child);
                dfs(child.right, child);
            }
        }
    }
}
