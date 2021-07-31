import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthBinaryTree {


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

    class Solution {
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
}
