import java.util.Arrays;
import java.util.Stack;

public class MaximumBinaryTree {

    /*
        @author: Linh Tran
        @version: July 30, 2021

        // O(N^2) approaches:
        Runtime and usage info of first solution:
        Runtime: 3 ms, faster than 40.49% of Java online submissions for Maximum Binary Tree.
        Memory Usage: 39.1 MB, less than 65.21% of Java online submissions for Maximum Binary Tree.

        Runtime and usage info of second solution:
        Runtime: 2 ms, faster than 87.41% of Java online submissions for Maximum Binary Tree.
        Memory Usage: 39.6 MB, less than 26.37% of Java online submissions for Maximum Binary Tree.

        // O(N) approach:
        Runtime: 6 ms, faster than 17.91% of Java online submissions for Maximum Binary Tree.
        Memory Usage: 39.2 MB, less than 65.21% of Java online submissions for Maximum Binary Tree.
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


    class Solution1 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return construct(nums, 0, nums.length-1);
        }

        private TreeNode construct(int[] nums, int low, int high){
            if (high-low+1 <=0){return null;} // no num left to create node

            int rootIndex = maxIndex(nums, low, high);
            TreeNode root = new TreeNode (nums[rootIndex]);
            root.left = construct(nums, low, rootIndex-1);
            root.right = construct(nums, rootIndex+1, high);

            return root;
        }

        private int maxIndex (int[] nums, int low, int high){
            int ans = low;
            for (int n=low; n<=high;n++){
                if (nums[n] > nums[ans]){
                    ans=n;
                }
            }

            return ans;
        }
    }

    class Solution3 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            Stack<TreeNode> st = new Stack<>();
            for (int n:nums){
                TreeNode curr = new TreeNode(n);
                // until empty or found a larger val, all of the
                // small nodes currently have (if any), will be on
                // the left branch of current node
                while(!st.isEmpty() && st.peek().val < curr.val){
                    curr.left = st.pop();
                }

                // if not empty but found a larger node
                if (!st.isEmpty()){
                    st.peek().right = curr;
                }

                st.push(curr);
            }

            // get the very bottom element
            while(st.size() > 1){
                st.pop();
            }

            return st.peek();
        }
    }
}
