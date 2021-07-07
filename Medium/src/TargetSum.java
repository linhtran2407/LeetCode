public class TargetSum {
/*
    @author: Linh Tran
    @version: July 07, 2021

    Runtime and usage info of DFS solution:
    Runtime: 475 ms, faster than 28.43% of Java online submissions for Target Sum.
    Memory Usage: 36.5 MB, less than 77.70% of Java online submissions for Target Sum.
*/

    // brute force solution
    class Solution {
        int count = 0;
        public int findTargetSumWays(int[] nums, int target) {
            dfs(nums,0,0,target);
            return count;
        }

        private void dfs(int[] nums, int index, int sum, int target){
            if (index == nums.length){
                if (sum == target){
                    count++;
                }
            } else {
                dfs(nums, index+1, sum + nums[index], target);
                dfs(nums, index+1, sum - nums[index], target);
            }
        }
    }
}
