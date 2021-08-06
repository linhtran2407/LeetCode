import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

    /*
    @author: Linh Tran
    @version: Aug 6th, 2021

    Runtime and usage info of BFS solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
    Memory Usage: 36.9 MB, less than 34.28% of Java online submissions for Sum of Left Leaves.

    Runtime and usage info of DFS solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Cousins in Binary Tree.
    Memory Usage: 36.3 MB, less than 98.34% of Java online submissions for Cousins in Binary Tree.
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
        public boolean isCousins(TreeNode root, int x, int y) {
            // same depth
            // different parents
            // brute force: keep track of the parents and traverse bfs
            // algo:
            // traverse level by level
            // at each level, detect if a node's EITHER children are x and y
            // assign parent node of x and y separately
            // check if parent of x and y are different -> return true

            // root cannot have cousin
            if (root.val == x || root.val == y){return false;}

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            // bfs
            while(!q.isEmpty()){
                int size = q.size();

                TreeNode xPar = null;
                TreeNode yPar = null;

                // traverse the current level
                for (int i=0; i<size; i++){
                    TreeNode curr = q.poll();

                    // detect if a node's EITHER children are x and y
                    if (curr.left != null){
                        if (curr.left.val == x){
                            xPar = curr;
                        } else if (curr.left.val == y){
                            yPar = curr;
                        }
                        q.add(curr.left);
                    }

                    if (curr.right != null){
                        if (curr.right.val == x){
                            xPar = curr;
                        } else if (curr.right.val == y){
                            yPar = curr;
                        }
                        q.add(curr.right);
                    }
                }

                if (xPar != null && yPar != null && xPar != yPar){return true;}
            }

            return false;
        }
    }

     // class Pair is provided on LeetCode
    /**
    class Solution_DFS {
        Pair<TreeNode, Integer> xPar;
        Pair<TreeNode, Integer> yPar;
        public boolean isCousins(TreeNode root, int x, int y) {
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
