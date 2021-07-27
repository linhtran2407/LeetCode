import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

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
        int count = 0;
        int target;
        Map<Integer, Integer> sumMap;
        public int pathSum(TreeNode root, int targetSum) {
            // simpler problem: continuous subarray sum
            // algo: use a hashmap to store all the running sum,
            // put (0,1) into the map for the case when distance of sum = 0
            // (in case the running sum itself == target => running sum - target == 0)
            // at each running sum, check if the running sum - target exists in the table
            // and increment count if there is.
            // always put/update running sum into the table during this process.
            // when reach the leaf, remove the running sum at that leaf before going to the parallel subtree
            // (remove the running some at leaf on the left, for example, before going on to the right subtree)

            // TC: O(N) with N being the number of nodes
            // SP: O(N) because each nodes has a running sum
            target = targetSum;
            // value is the curr sum, key is the frequent of the sum
            sumMap = new HashMap<>();
            sumMap.put(0, 1);
            traverseAndCalcSum(root, 0);
            return count;
        }

        private void traverseAndCalcSum(TreeNode node, int currSum){
            if (node == null){return;}

            currSum += node.val;

            if (sumMap.containsKey(currSum - target)){
                count += sumMap.get(currSum - target);
            }

            sumMap.put(currSum, sumMap.getOrDefault(currSum, 0)+1);

            traverseAndCalcSum(node.left, currSum);
            traverseAndCalcSum(node.right, currSum);

            sumMap.put(currSum, sumMap.get(currSum)-1);
        }
    }
}
