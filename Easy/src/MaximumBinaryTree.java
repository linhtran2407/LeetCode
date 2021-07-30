public class MaximumBinaryTree {


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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums.length == 0){return null;}

            int maxIdx = 0;
            for(int n=0; n<nums.length; n++){
                maxIdx = nums[n] > nums[maxIdx]? n:maxIdx;
            }

            TreeNode root = new TreeNode(nums[maxIdx]);
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx+1, nums.length));

            return root;
        }
    }
}
