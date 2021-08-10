public class AllElementsInTwoBinarySearchTrees {


     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            // brute force:
            // let m be the size of tree 1 and n be the size of tree 2
            // use 2 arrays with size m and n containing all nodes in both trees
            // use inorder traversal to put the nodes into the tree
            // the 2 arrays will be sorted in ascending order using inorder traversal
            // loop through both arrays at the same time, use 2 pointers and contanstly add
            // the smaller values at either of the pointer, then update the pointer(s) until both pointers reach the end of both arrays
            // TC: O(M+N) to iterate through both trees and both arrays
            // SC: O(M+N) to store both arrays and the result list

            List<Integer> res = new ArrayList<>();

            // build the ascending arrays of both trees
            Queue<Integer> list1 = new LinkedList<>();
            Queue<Integer> list2 = new LinkedList<>();
            inorder(root1, list1);
            inorder(root2, list2);

            // merge and sort the 2 lists
            while(!list1.isEmpty() || !list2.isEmpty()){
                int val1 = list1.isEmpty()? Integer.MAX_VALUE : list1.peek();
                int val2 = list2.isEmpty()? Integer.MAX_VALUE : list2.peek();

                // compare, add, and pop the smaller value. if equal, add both
                if (val1 < val2){
                    res.add(val1);
                    list1.poll();
                } else if (val2 < val1){
                    res.add(val2);
                    list2.poll();
                } else {
                    res.add(val1);
                    res.add(val2);
                    list1.poll();
                    list2.poll();
                }
            }

            return res;
        }

        private void inorder(TreeNode root, Queue<Integer> list){
            if (root == null){
                return;
            }

            inorder(root.left, list);
            list.offer(root.val);
            inorder(root.right, list);
        }
    }
}
