import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthBinaryTree {
        /*
        @author: Linh Tran
        @version: July 31, 2021

        Runtime and usage info of BFS solution:
        Runtime: 1 ms, faster than 97.26% of Java online submissions for Maximum Width of Binary Tree.
        Memory Usage: 38.6 MB, less than 77.22% of Java online submissions for Maximum Width of Binary Tree.

        Runtime and usage info of DFS solution:
        Runtime: 1 ms, faster than 97.26% of Java online submissions for Maximum Width of Binary Tree.
        Memory Usage: 39.1 MB, less than 41.98% of Java online submissions for Maximum Width of Binary Tree.
    */


     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     public class Pair {
         TreeNode node;
         int index;
         Pair(TreeNode node, int index){
             this.node = node;
             this.index = index;
         }
         Pair(){ }
         public TreeNode getKey(){return this.node;}
         public int getValue(){return this.index;}
     }

    class Solution_BFS {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null){
                return 0;
            }

            int res = 1; // root is not null -> current width = 1
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0));

            while(!q.isEmpty()){
                Pair currHeadLevel = q.peek();
                Pair currTailLevel = null;
                int size = q.size();

                for (int i=0; i<size; i++){
                    currTailLevel = q.poll();
                    int indexTail = currTailLevel.index;
                    TreeNode currTailNode = currTailLevel.node;
                    if (currTailNode.left != null){
                        q.add(new Pair(currTailNode.left, indexTail*2));
                    }
                    if (currTailNode.right != null){
                        q.add(new Pair(currTailNode.right, indexTail*2+1));
                    }
                }

                res = Math.max(res, currTailLevel.index - currHeadLevel.index + 1);
            }
            return res;
        }
    }

    class Solution_DFS {
        // dfs: keep track of the first node's index of each level/depth
        // in a table with depth being the key and the index of the first node on that depth
        // being the value
        // at each dfs, when traversing through each node, update the max width
        // by checking if the current node's index - the first node's index on the same
        // level with the current node + 1 is greater than the current max width
        private int maxWidth;
        private Map<Integer, Integer> firstNodeIndices;

        private void dfs(TreeNode node, int depth, int index){
            if (node == null){return;}
            if (!firstNodeIndices.containsKey(depth)){
                firstNodeIndices.put(depth, index);
            }

            int firstNodeIndex = firstNodeIndices.get(depth);
            maxWidth = Math.max(maxWidth, index-firstNodeIndex+1);

            dfs(node.left, depth+1, index*2);
            dfs(node.right, depth+1, index*2+1);
        }
        public int widthOfBinaryTree(TreeNode root) {
            maxWidth = 0;
            if (root == null){return this.maxWidth;}
            firstNodeIndices = new HashMap<>();
            dfs(root, 0, 0);
            return this.maxWidth;
        }
    }
}
