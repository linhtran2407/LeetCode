public class ValidateBST {



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
     *     }
     * }
     */
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
}
