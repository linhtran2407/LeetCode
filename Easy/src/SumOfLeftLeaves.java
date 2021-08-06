public class SumOfLeftLeaves {


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

    class Solution_BFS {
        public int sumOfLeftLeaves(TreeNode root) {
            int ans = 0;
            if (root == null){
                return ans;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();

                for(int i=0; i<size; i++){
                    TreeNode curr = q.poll();

                    TreeNode leftChild = curr.left;
                    if (leftChild != null){
                        if (leftChild.left == null && leftChild.right == null){
                            ans += leftChild.val;
                        }
                        q.add(leftChild);
                    }

                    if (curr.right != null){
                        q.add(curr.right);
                    }
                }
            }

            return ans;
        }
    }

     /**
    class Solution_DFS {
         // class Pair is built-in on LeetCode
        Pair<TreeNode, Integer> xPar;
        Pair<TreeNode, Integer> yPar;
        public boolean isCousins(TreeNode root, int x, int y) {
            // try dfs
            // brute force: keep track of the parents and traverse bfs
            // algo:
            // traverse level by level
            // at each level, detect if a node's EITHER children are x and y
            // assign parent node of x and y separately
            // check if parent of x and y are different -> return true

            if (root.val == x || root.val == y){return false;}

            xPar = new Pair(null,-1);
            yPar = new Pair(null,-1);

            findPar(root, x, y, 0);

            TreeNode xParNode = xPar.getKey();
            TreeNode yParNode = yPar.getKey();
            int xParDepth = xPar.getValue();
            int yParDepth = yPar.getValue();
            // if found parents on the same level, check if they are not the same
            return xParNode != null && yParNode != null && xParNode != yParNode && xParDepth == yParDepth;
        }

        // find x and y's parent
        private void findPar(TreeNode root, int x, int y, int depth){
            if (root == null){return;}

            if (root.left != null){
                if (root.left.val == x){
                    xPar = new Pair(root,depth);
                } else if (root.left.val == y){
                    yPar = new Pair(root,depth);
                }
            }

            if (root.right != null){
                if (root.right.val == x){
                    xPar = new Pair(root,depth);
                } else if (root.right.val == y){
                    yPar = new Pair(root,depth);
                }
            }

            // if found both x's or y's parent(s), return
            if (xPar.getKey() != null && yPar.getKey() != null){return;}

            findPar(root.left, x, y, depth+1);
            findPar(root.right, x, y, depth+1);
        }

    }

      */
}
