import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

     //Definition for a binary tree node.
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
        // TC: build map O(N), recursion O(N) --> total: O(N)
        // SC: map O(N)
        Map<Integer, Integer> inorderIndexMap;
        int rootPreorderIndex;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderIndexMap = new HashMap<>();
            rootPreorderIndex = 0;

            // build the map
            // Key: root.val, Val: root's inorder index
            for (int n=0; n<inorder.length; n++){
                inorderIndexMap.put(inorder[n], n);
            }

            return recursion(0, inorder.length-1, preorder);
        }

        private TreeNode recursion(int low, int high, int[] preorder){
            if (high-low+1 == 0){return null;} // if no value left to build

            // initialize the root, keep incrementing the root index
            // since we treat all nodes in preorder to be root of a subtree
            TreeNode root = new TreeNode(preorder[rootPreorderIndex]);

            // use the root index to be the delimiter of left and right children
            int rootInorderIndex = inorderIndexMap.get(preorder[rootPreorderIndex++]);
            root.left = recursion(low, rootInorderIndex-1, preorder);
            root.right = recursion(rootInorderIndex+1, high, preorder);

            return root;
        }
    }
}
